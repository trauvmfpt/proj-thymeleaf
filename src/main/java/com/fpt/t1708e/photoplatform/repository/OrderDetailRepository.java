package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findByOrderProductId(long id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table order_detail AUTO_INCREMENT = 1")
    void resetIncrement();

    @Query("SELECT o FROM OrderDetail o where o.product.id = :productId and o.orderProduct.id = :orderId")
    OrderDetail findByProductIdAndOrderId(long productId, long orderId);

    @Modifying
    @Query("DELETE FROM OrderDetail o WHERE o.id = :id")
    @Transactional
    void delete(long id);
}
