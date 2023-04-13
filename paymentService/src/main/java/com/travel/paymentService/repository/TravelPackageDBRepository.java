package com.travel.paymentService.repository;

import com.travel.paymentService.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageDBRepository extends JpaRepository<TravelPackage,Long> {
}
