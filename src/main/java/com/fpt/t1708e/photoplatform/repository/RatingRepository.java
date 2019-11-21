package com.fpt.t1708e.photoplatform.repository;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Comment;
import com.fpt.t1708e.photoplatform.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    @Query("SELECT r FROM Rating r where r.album.id = :id or r.product.id = :id or r.studioInfo.id = :id or r.photographerInfo.id = :id")
    List<Rating> findByPostId(long id);

    @Query("SELECT r FROM Rating r where (r.customerInfo.id = :accountId and r.product.id = :postId)" +
            "or (r.customerInfo.id = :accountId and r.album.id = :postId)" +
            "or (r.customerInfo.id = :accountId and r.photographerInfo.id = :postId) " +
            "or (r.customerInfo.id = :accountId and r.studioInfo.id = :postId)")
    Rating findByUserIdAndPostId(long accountId, long postId);
}
