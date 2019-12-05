package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.AdminInfo;
import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.repository.AdminInfoRepository;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInfoService {
    @Autowired
    AdminInfoRepository adminInfoRepository;
    public List<AdminInfo> adminInfos(){return adminInfoRepository.findAll();}
}
