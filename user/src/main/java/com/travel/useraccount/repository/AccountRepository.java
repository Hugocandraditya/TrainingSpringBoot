package com.travel.useraccount.repository;

import com.travel.useraccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);

    Optional<Account> findById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends Account> S save(S entity);

}
