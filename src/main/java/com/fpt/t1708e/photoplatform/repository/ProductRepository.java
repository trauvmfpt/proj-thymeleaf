package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(nativeQuery = true,value = "select * FROM product where destination like %:key% order by destination desc limit 5")
    List<Product> getTop5(@Param("key") String key);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table product AUTO_INCREMENT = 1")
    void resetIncrement();
    @Query(nativeQuery = true,value = "select * FROM product where category_id = :cateId order by price_discount desc limit 1")
    Product getTop1DiscountByCategory(@Param("cateId") long cateId);
    @Query(nativeQuery = true,value = "select * FROM product order by average_rate desc limit 10")
    List<Product> getTop10Rating();
    List<Product> getProductByPhotographerInfoId(@Param("photographer") long id);
    List<Product> getProductByStudioInfoId(@Param("studio") long id);
    @Query("SELECT c FROM Product c where c.name LIKE %:key% or c.description LIKE %:key% or c.content LIKE %:key% ")
    List<Product> getAllByKey(String key);
}
