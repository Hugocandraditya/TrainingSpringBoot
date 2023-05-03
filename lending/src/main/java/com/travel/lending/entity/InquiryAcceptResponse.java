package com.travel.lending.entity;

import com.travel.lending.entity.client.product.LendingProduct;
import lombok.Data;

import java.util.List;


@Data
public class InquiryAcceptResponse extends InquiryResponse{
    List<LendingProduct> lendingProductList;
}
