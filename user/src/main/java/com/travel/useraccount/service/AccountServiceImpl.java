package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.model.UpdateAccount;
import com.travel.useraccount.repository.AccountRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void updateBalance(UpdateAccount updateAccount) {
        List<Account> accountListBorrower = accountRepository.findByUserId(updateAccount.getUserIdBorrower());
        List<Account> accountListLender = accountRepository.findByUserId(updateAccount.getUserIdLender());

        Account accountBorrower = accountListBorrower.stream().filter(account -> updateAccount.getAccountBorrower().equals(account.getAcc_number()))
                .findFirst().get();

        Account accountLender = accountListLender.stream().filter(account -> updateAccount.getAccountLender().equals(account.getAcc_number()))
                .findFirst().get();

        accountBorrower.setBalance(accountBorrower.getBalance().add(updateAccount.getAmount()));
        accountLender.setBalance(accountLender.getBalance().add(updateAccount.getAmount()));

        accountRepository.save(accountBorrower);
        accountRepository.save(accountLender);
    }
}