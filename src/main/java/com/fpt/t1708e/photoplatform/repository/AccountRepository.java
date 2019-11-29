package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<List<Account>> findAllAccountByRole(int role);

    Account findAccountByUsername(String userName);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table account AUTO_INCREMENT = 1")
    void resetIncrement();
}
