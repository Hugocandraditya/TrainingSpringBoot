package com.travel.product.repository;

import com.travel.product.model.LendingProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingProductRepository extends JpaRepository<LendingProductModel,Long> {
}
