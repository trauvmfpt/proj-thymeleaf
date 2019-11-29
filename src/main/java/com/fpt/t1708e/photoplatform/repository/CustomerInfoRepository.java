package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
    CustomerInfo findByAccount_Id(long accountId);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table customer_info AUTO_INCREMENT = 1")
    void resetIncrement();
}
