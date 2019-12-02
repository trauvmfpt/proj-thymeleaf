package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;
    public OrderProduct getById(long id){return orderProductRepository.findById(id).orElse(null);}
}
