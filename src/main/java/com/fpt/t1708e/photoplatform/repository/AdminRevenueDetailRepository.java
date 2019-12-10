package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.AdminRevenueDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface AdminRevenueDetailRepository extends JpaRepository<AdminRevenueDetail, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table admin_revenue_detail AUTO_INCREMENT = 1")
    void resetIncrement();

    @Query("SELECT sum(rd.currentPrice) FROM AdminRevenueDetail rd left join rd.adminRevenue r where r.status = 3 and rd.status = 3" +
            "and month(rd.createdAt) = :month")
    double getMonthlyRevenue(int month);

    @Query("SELECT SUM(rd.currentPrice) as revenue, rd.createdAt as day FROM AdminRevenueDetail rd left join rd.adminRevenue r where r.status = 3 and rd.status = 3" +
            "and (rd.createdAt between :startDate and :endDate) " +
            "group by rd.createdAt order by rd.createdAt")
    List<Object[]> getRevenue(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT sum(rd.currentPrice) as quantity, s.fullName as studioName FROM AdminRevenueDetail rd left join rd.adminRevenue r left join rd.studioInfo s where " +
            "rd.status = 3 and r.status = 3" +
            "and (rd.createdAt between :startDate and :endDate) and rd.studioInfo is not null " +
            "group by s.id order by sum(rd.currentPrice) desc")
    List<Object[]> getPopularStudio(LocalDate startDate, LocalDate endDate, Pageable pageable);

    @Query(value = "SELECT sum(rd.currentPrice) as quantity, ph.fullName as photographerName FROM AdminRevenueDetail rd left join rd.adminRevenue r left join rd.photographerInfo ph where " +
            "rd.status = 3 and r.status = 3" +
            "and (rd.createdAt between :startDate and :endDate) and rd.photographerInfo is not null " +
            "group by ph.id order by sum(rd.currentPrice) desc")
    List<Object[]> getPopularPhotographer(LocalDate startDate, LocalDate endDate, Pageable pageable);
}
