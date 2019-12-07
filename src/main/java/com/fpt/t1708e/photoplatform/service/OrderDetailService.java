package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;

import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> orderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

	public OrderDetail getOrderDetailById(long id) {
		return orderDetailRepository.findById(id).orElse(null);
	}

    public OrderDetail update(OrderDetail orderDetail) {
        orderDetail.setUpdatedAt(LocalDate.now());
        return orderDetailRepository.save(orderDetail);
    }
    public OrderDetail delete(OrderDetail orderDetail) {
        orderDetail.setUpdatedAt(LocalDate.now());
        orderDetail.setDeletedAt(LocalDate.now());
        orderDetail.setStatus(0);
        return orderDetailRepository.save(orderDetail);
    }
    public List<OrderDetail> getByOrderProductId(long id){return orderDetailRepository.findByOrderProductId(id);}
}
