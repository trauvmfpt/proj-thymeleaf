package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }
//    public List<Product> getByCategoryId(long id) {
//        return productRepository.findAllByCategory_Id(id);
//    }
    public List<Product> products(){return productRepository.findAll();}

    public Page<Product> productsWithPagination(Pageable pageable){
        List<Product> products = productRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }
        Page<Product> bookPage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), products.size());

        return bookPage;
//        return productRepository.findAll(PageRequest.of(page - 1,limit));
    }
}
