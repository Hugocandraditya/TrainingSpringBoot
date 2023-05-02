package com.travel.lending.repository;

import com.travel.lending.enitity.client.product.LendingProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@FeignClient(value = "lending-product-client", url = "${url.lendingproduct}")
public interface LendingProductRepository {
    @GetMapping
    List<LendingProduct> inquiryAllLendingProduct(
            URI url);

    @GetMapping
    List<LendingProduct> inquiryLendingProductByLenderId(
            URI url,
            @RequestParam Long lenderId);

    @GetMapping
    List<LendingProduct> inquiryLendingProductByBorrowerId(
            URI url,
            @RequestParam Long borrowerId);
    @GetMapping
    LendingProduct inquiryLendingProductById(
            URI url,
            @RequestParam Long id);


    @PostMapping
    LendingProduct createProduct(
            URI url,
            @RequestBody LendingProduct request);

    @PutMapping
    LendingProduct updateProduct(
            URI url,
            @RequestBody LendingProduct request);

    @DeleteMapping
    void deleteProduct(
            URI url,
            @RequestParam Long id);
}


