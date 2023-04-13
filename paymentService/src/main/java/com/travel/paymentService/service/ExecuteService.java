package com.travel.paymentService.service;

import com.travel.paymentService.entity.ExecuteRequest;
import com.travel.paymentService.entity.ExecuteResponse;
import com.travel.paymentService.entity.client.User;
import com.travel.paymentService.model.PaymentHistory;
import com.travel.paymentService.repository.PaymentHistoryDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecuteService {
    @Autowired
    PaymentHistoryDBRepository paymentHistoryRepo;

    @Autowired
    UserService userService;

    public ExecuteResponse execute(Long userId, ExecuteRequest request){
//        TODO: inquiry user
        User user = userService.getUserById(userId);
//        TODO: verif id
        if(user == null)
            throw new RuntimeException("Failed presentment");
//        TODO: verif password/pin
        if(userService.verifyUser(userId,request.getPin()))
            throw new RuntimeException("Verification Failed");
//        TODO: inquriy data by paymentHistory Id
        PaymentHistory paymentHistory = updatePaymentHistory(request);
//        TODO: mapping response
        return mappingExecuteResponse(paymentHistory);
    }

    private ExecuteResponse mappingExecuteResponse(PaymentHistory paymentHistory) {
        ExecuteResponse response = new ExecuteResponse();
        response.setName(paymentHistory.getName());
        response.setAccount(paymentHistory.getAccountNumber());
        response.setPackageName(paymentHistory.getPackageName());
        response.setCount(paymentHistory.getCount().toString());
        response.setTotal(paymentHistory.getTotal().toString());
        response.setStatus(paymentHistory.getStatus());
        return response;
    }

    private PaymentHistory updatePaymentHistory(ExecuteRequest request) {

        Optional<PaymentHistory> paymentHistoryOpt = paymentHistoryRepo.findById(request.getPaymentHistoryId());
        PaymentHistory paymentHistory = paymentHistoryOpt.get();

        paymentHistory.setStatus("SUCCESS");

        paymentHistory = paymentHistoryRepo.save(paymentHistory);

        return paymentHistory;
    }
}
