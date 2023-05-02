package com.travel.lending.service;

import com.travel.lending.enitity.client.product.LendingProduct;
import com.travel.lending.repository.LendingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class LendingProductService {

    @Value(value = "${url.createProductLending}")
    private String createProductLendingUrl;

    @Value(value = "${url.updateProductLending}")
    private String updateProductLendingUrl;

    @Value(value = "${url.getProductLendingList}")
    private String getProductLendingList;

    @Value(value = "${url.getProductLendingById}")
    private String getProductLendingById;
    @Autowired
    private LendingProductRepository lendingProductRepository;

    public LendingProduct createLendingProduct(LendingProduct lendingProduct) {
        try {
            return lendingProductRepository.createProduct(new URI(createProductLendingUrl),lendingProduct);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public LendingProduct updateLendingProduct(LendingProduct lendingProduct) {
        try {
            return lendingProductRepository.updateProduct(new URI(createProductLendingUrl),lendingProduct);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LendingProduct> getLendingProductList() {
        try {
            return lendingProductRepository.inquiryAllLendingProduct(new URI(getProductLendingList));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public LendingProduct getLendingProductById(Long productId) {
        try {
            return lendingProductRepository.inquiryLendingProductById(new URI(getProductLendingById), productId);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
