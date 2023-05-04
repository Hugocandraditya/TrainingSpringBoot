package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public AccountList findByUserId(Long userId) {

        List<Account> accountList = accountRepository.findByUserId(userId);
        AccountList accountList1 = new AccountList();
        accountList1.setAccountList(accountList);
        return accountList1;
    }

    @Override
    public AccountRepository deleteById(Long id) {
        accountRepository.deleteById(id);
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void updateBalance(Long amount, Optional<Account> borrowerAccount, Optional<Account> lenderAccount) {
        borrowerAccount = Optional.of(accountRepository.findById(borrowerAccount.get().getId()).get());
        lenderAccount = Optional.of(accountRepository.findById(lenderAccount.get().getId()).get());
        Long borrowerNewBalance = borrowerAccount.get().getBalance() + amount;
        Long lenderNewBalance = lenderAccount.get().getBalance() - amount;
        borrowerAccount.get().setBalance(borrowerNewBalance);
        lenderAccount.get().setBalance(lenderNewBalance);
        System.out.println(borrowerNewBalance);
        System.out.println(lenderNewBalance);
    }

}