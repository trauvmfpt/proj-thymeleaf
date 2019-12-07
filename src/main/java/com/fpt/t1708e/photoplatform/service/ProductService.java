package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.repository.CategoryRepository;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        product.setUpdatedAt(LocalDate.now());
        return productRepository.save(product);
    }

    public List<Product> products(){return productRepository.findAll();}

    public Page<Product> productsWithPagination(long photographerId, long studioId, Pageable pageable){
        List<Product> products;
        if (photographerId != 0 && studioId == 0){
            products = productRepository.getProductByPhotographerInfoId(photographerId);
        } else if (studioId != 0 && photographerId == 0) {
            products = productRepository.getProductByStudioInfoId(studioId);
        } else {
            products = productRepository.findAll();
        }
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
    public List<Product> getList() {
        return productRepository.findAll();
    }
    public List<Product> getProductByDiscountEachCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for (Category category : categoryList
        ){
           Product product = productRepository.getTop1DiscountByCategory(category.getId());
           if (product != null){
               productList.add(product);
           }
        }
        return productList;
    }
    public List<Product> getProductByTopRate(){

        List<Product> productList = productRepository.getTop10Rating();

        return productList;
    }

    public List<Product> getProductBestSeller() {
        List<Product> productList = new ArrayList<>();
        return productList;
    }

    public List<Product> getAllByKey(String key) {
        return productRepository.getAllByKey(key);
    }
}
