package com.travel.product.service;

import com.travel.product.enitity.LendingProduct;
import com.travel.product.model.LendingProductModel;
import com.travel.product.repository.LendingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LendingProductService {

    @Autowired
    LendingProductRepository lendingProductRepository;

    public List<LendingProduct> inquiryAllLendingProduct(){
        List<LendingProductModel> lendingProductModelList = lendingProductRepository.findAll();
        return lendingProductModelList.stream()
                .map(LendingProductHelper::mapLendingProduct).toList();
    }

    public List<LendingProduct> inquiryLendingProductByLenderId(Long lenderId){
        List<LendingProductModel> lendingProductModelList = lendingProductRepository.findAll();
        return lendingProductModelList.stream()
                .filter(lendingProductModel -> lenderId.equals(lendingProductModel.getUserIdLender()))
                .map(LendingProductHelper::mapLendingProduct).toList();
    }

    public List<LendingProduct> inquiryLendingProductByBorrowerId(Long borrowerId){
        List<LendingProductModel> lendingProductModelList = lendingProductRepository.findAll();
        return lendingProductModelList.stream()
                .filter(lendingProductModel -> borrowerId.equals(lendingProductModel.getUserIdBorrower()))
                .map(LendingProductHelper::mapLendingProduct).toList();
    }

    public LendingProduct inquiryLendingProductById(Long id){
        Optional<LendingProductModel> lendingProductModelOptional = lendingProductRepository.findById(id);
        return lendingProductModelOptional.map(LendingProductHelper::mapLendingProduct).orElseGet(LendingProduct::new);
    }

    public LendingProduct createUpdateProduct(LendingProduct lendingProduct){
        LendingProductModel lendingProductModel = LendingProductHelper.mapLendingProductModel(lendingProduct);
        lendingProductModel = lendingProductRepository.save(lendingProductModel);
        return LendingProductHelper.mapLendingProduct(lendingProductModel);
    }

    public void deleteProduct(Long id){
        lendingProductRepository.deleteById(id);
    }
}
