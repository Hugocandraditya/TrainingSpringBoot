package com.travel.useraccount.model;

import jakarta.persistence.*;

import java.util.List;

public class AccountList {
    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}