package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount();
    void addAccount(AccountDAO accountDAO, boolean sig);

    List<Account> findAccounts();

    String getName();
    void setName(String name);

    List<Account> findAccounts(boolean trip);
}
