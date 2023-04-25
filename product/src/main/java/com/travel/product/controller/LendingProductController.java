package com.travel.product.controller;

import com.travel.product.enitity.LendingProduct;
import com.travel.product.service.LendingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lending-product")
public class LendingProductController {
    @Autowired
    LendingProductService lendingProductService;

    @GetMapping("/all")
    public List<LendingProduct> inquiryAllLendingProduct(){
        return lendingProductService.inquiryAllLendingProduct();
    }

    @GetMapping("/lenderId")
    public List<LendingProduct> inquiryLendingProductByLenderId(
            @RequestParam Long lenderId){
        return lendingProductService.inquiryLendingProductByLenderId(lenderId);
    }

    @GetMapping("/borrowerId")
    public List<LendingProduct> inquiryLendingProductByBorrowerId(
            @RequestParam Long borrowerId){
        return lendingProductService.inquiryLendingProductByBorrowerId(borrowerId);
    }
    @GetMapping("/id")
    public LendingProduct inquiryLendingProductById(
            @RequestParam Long id){
        return lendingProductService.inquiryLendingProductById(id);
    }


    @PostMapping("/create")
    public LendingProduct createProduct(
            @RequestBody LendingProduct request){
        request.setId(null);
        return lendingProductService.createUpdateProduct(request);
    }

    @PutMapping("/update")
    public LendingProduct updateProduct(
            @RequestBody LendingProduct request){
        return lendingProductService.createUpdateProduct(request);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(
            @RequestParam Long id){
        lendingProductService.deleteProduct(id);
    }
}
