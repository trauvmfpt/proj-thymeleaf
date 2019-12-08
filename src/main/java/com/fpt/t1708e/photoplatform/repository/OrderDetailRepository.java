package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.dto.RevenueDTO;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.Date;
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

    @Query("SELECT o FROM OrderDetail o left join o.orderProduct op left join  o.product p left join p.studioInfo s left join p.photographerInfo ph where (ph.account.id = :id or s.account.id = :id) and op.status = 1")
    List<OrderDetail> findByAccountId(long id);

    @Query("SELECT SUM(o.currentPrice) as revenue, o.createdAt as day FROM OrderDetail o left join o.orderProduct op left join o.product p left join p.studioInfo s left join p.photographerInfo ph where " +
            "(ph.account.id = :id or s.account.id = :id) " +
            "and op.status = 3 and o.status = 3" +
            "and (o.createdAt between :startDate and :endDate) " +
            "group by o.createdAt order by o.createdAt")
    List<Object[]> getRevenue(long id, LocalDate startDate, LocalDate endDate);

    @Query("SELECT sum(o.currentPrice) as quantity, p.name as product FROM OrderDetail o left join o.orderProduct op left join o.product p left join p.studioInfo s left join p.photographerInfo ph where " +
            "(ph.account.id = :id or s.account.id = :id) " +
            "and op.status = 3 and o.status = 3" +
            "and (o.createdAt between :startDate and :endDate) " +
            "group by p.name order by p.name")
    List<Object[]> getPopularProduct(long id, LocalDate startDate, LocalDate endDate);

    @Query("SELECT sum(o.currentPrice) FROM OrderDetail o left join o.orderProduct op left join o.product p left join p.studioInfo s left join p.photographerInfo ph where" +
            "(ph.account.id = :id or s.account.id = :id) " +
            "and op.status = 3 and o.status = 3" +
            "and month(o.createdAt) = :month")
    double getMonthlyRevenue(long id, int month);

    @Query("SELECT o FROM OrderDetail o left join o.orderProduct op left join o.product p left join p.studioInfo s left join p.photographerInfo ph where" +
            "(ph.account.id = :id or s.account.id = :id) " +
            "and op.status = 1 and o.status = 2")
    List<OrderDetail> getProcessingOrderDetail(long id);


    @Query("SELECT o FROM OrderDetail o join o.product p left join p.studioInfo s left join p.photographerInfo ph where (s.account.id = :accountId or ph.account.id = :accountId) and o.orderProduct.id =:orderId")
    List<OrderDetail> findByAccountIdAndOrderId(long accountId, long orderId);

    @Modifying
    @Query("DELETE FROM OrderDetail o WHERE o.id = :id")
    @Transactional
    void delete(long id);
}
