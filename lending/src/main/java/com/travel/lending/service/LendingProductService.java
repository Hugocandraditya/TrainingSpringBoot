package com.travel.lending.service;

import com.travel.lending.enitity.client.product.LendingProduct;
import com.travel.lending.repository.LendingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LendingProductService {

    @Value(value = "${url.getcreateProductLending}")
    private String createProductLendingUrl;
    @Autowired
    private LendingProductRepository lendingProductRepository;

    public LendingProduct createLendingProduct(LendingProduct lendingProduct) {
        try {
            return lendingProductRepository.createProduct(new URI(createProductLendingUrl),lendingProduct);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
