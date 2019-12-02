package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {
    @Autowired
    CustomerInfoRepository customerInfoRepository;
    public CustomerInfo getCustomerInfoByAccount(long accountId){
        return customerInfoRepository.findByAccount_Id(accountId);
    }
}
