package com.fpt.t1708e.photoplatform.service;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.repository.CategoryRepository;
import com.fpt.t1708e.photoplatform.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    public OrderProduct getById(long id){return orderProductRepository.findById(id).orElse(null);}

    public List<OrderProduct> orders(){return orderProductRepository.findAll();}

    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

	public OrderProduct getOrderProductById(long id) {
		return orderProductRepository.findById(id).orElse(null);
	}

    public OrderProduct getOrderProductByIdAndStatus(long id, int status) {
         if(orderProductRepository.findByIdAndStatus(id, status) != null){
             return orderProductRepository.findByIdAndStatus(id, status);
         }
         return null;
    }

    public OrderProduct update(OrderProduct orderProduct) {
        orderProduct.setUpdatedAt(LocalDate.now());
        return orderProductRepository.save(orderProduct);
    }
    public OrderProduct delete(OrderProduct orderProduct) {
        orderProduct.setUpdatedAt(LocalDate.now());
        orderProduct.setDeletedAt(LocalDate.now());
        orderProduct.setStatus(0);
        return orderProductRepository.save(orderProduct);
    }
}
