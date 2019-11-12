package com.fpt.t1708e.photoplatform.config;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.rmi.RemoteException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountService.findByUserName(s);
        UserDetails userDetails =
                User.builder()
                        .username(account.getUsername())
                        .password(account.getPassword())
                        .roles(Integer.toString(account.getRole()))
                        .build();
        return userDetails;
    }
}