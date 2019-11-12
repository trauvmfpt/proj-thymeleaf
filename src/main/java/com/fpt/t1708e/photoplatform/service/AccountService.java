package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }
    public List<Account> findAllAccountByRole(int role) {
//    	List<Account> accounts = new ArrayList<Account>();
    	
        return accountRepository.findAllAccountByRole(role).get();
    }
}
