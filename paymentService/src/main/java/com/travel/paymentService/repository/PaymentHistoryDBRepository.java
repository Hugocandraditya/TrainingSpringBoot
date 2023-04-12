package com.travel.paymentService.repository;

import com.travel.paymentService.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryDBRepository extends JpaRepository<PaymentHistory,Integer> {
}
