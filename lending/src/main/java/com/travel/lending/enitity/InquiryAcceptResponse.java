package com.travel.lending.enitity;

import com.travel.lending.enitity.client.product.LendingProduct;
import lombok.Data;

import java.util.List;


@Data
public class InquiryAcceptResponse extends InquiryResponse{
    List<LendingProduct> lendingProductList;
}
