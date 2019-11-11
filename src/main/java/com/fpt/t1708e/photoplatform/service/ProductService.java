package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
