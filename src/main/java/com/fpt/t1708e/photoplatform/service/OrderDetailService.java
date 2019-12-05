package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;

import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
        orderDetail.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return orderDetailRepository.save(orderDetail);
    }
    public OrderDetail delete(OrderDetail orderDetail) {
        orderDetail.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        orderDetail.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        orderDetail.setStatus(0);
        return orderDetailRepository.save(orderDetail);
    }
    public List<OrderDetail> getByOrderProductId(long id){return orderDetailRepository.findByOrderProductId(id);}
}
