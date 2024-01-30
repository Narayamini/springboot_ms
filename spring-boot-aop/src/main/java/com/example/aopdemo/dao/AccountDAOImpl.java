package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements  AccountDAO{
    private String name;

    public String getName() {
        System.out.println(getClass()+" getter method of impl");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" setter method of impl");
        this.name = name;
    }

    @Override
    public List<Account> findAccounts(boolean trip) {
        if(trip)
        {
            throw new RuntimeException("Exceeeeeptionnnn");
        }
        List<Account> accountList = new ArrayList<>();
        Account acc1=new Account("harry","Gold");
        Account acc2=new Account("potter","Silver");
        Account acc3=new Account("dumbledore","Platinum");
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        return accountList;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass()+" adding acct");
    }

    @Override
    public void addAccount(AccountDAO accountDAO, boolean sig) {
        System.out.println(getClass()+" adding acct with params");
    }

    @Override
    public List<Account> findAccounts() {
        //add them to our accounts list
        return findAccounts(false);
    }
}
