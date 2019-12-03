package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    public List<OrderDetail> getByOrderProductId(long id){return orderDetailRepository.findByOrderProductId(id);}
}
