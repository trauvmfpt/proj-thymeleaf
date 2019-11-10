package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
