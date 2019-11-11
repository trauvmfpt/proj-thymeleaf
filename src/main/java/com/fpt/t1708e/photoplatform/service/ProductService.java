package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product create(Product product) {
        product.setStatus(1);
        product.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }

    public Product update(Product product) {
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }
}
