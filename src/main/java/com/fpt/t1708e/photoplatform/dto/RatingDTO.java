package com.fpt.t1708e.photoplatform.dto;

import com.fpt.t1708e.photoplatform.entity.*;

import javax.persistence.*;

public class RatingDTO {
    private long id;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;
    private float value;
    private long albumId;
    private long productId;
    private long studioId;
    private long accountId;
    private long photographerId;
    private String userName;

    public RatingDTO() {
    }

    public RatingDTO(Rating rating) {
        this.userName = rating.getCustomerInfo().getFullName();
        this.accountId = rating.getCustomerInfo().getId();
        if(rating.getAlbum() != null){
            this.albumId = rating.getAlbum().getId();
        }
        if(rating.getProduct() != null){
            this.productId = rating.getProduct().getId();
        }
        if(rating.getPhotographerInfo() != null){
            this.photographerId = rating.getPhotographerInfo().getId();
        }
        if(rating.getStudioInfo() != null){
            this.studioId = rating.getStudioInfo().getId();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getStudioId() {
        return studioId;
    }

    public void setStudioId(long studioId) {
        this.studioId = studioId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(long photographerId) {
        this.photographerId = photographerId;
    }
}
