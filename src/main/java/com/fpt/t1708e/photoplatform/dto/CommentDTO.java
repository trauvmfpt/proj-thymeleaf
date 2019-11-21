package com.fpt.t1708e.photoplatform.dto;

import com.fpt.t1708e.photoplatform.entity.*;

import javax.persistence.*;

public class CommentDTO {
    private long id;
    private float value;
    private String content;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private long albumId;
    private long productId;
    private long studioId;
    private long photographerId;
    private long accountId;
    private int status;
    private String userName;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CommentDTO() {
    }

    public long getStudioId() {
        return studioId;
    }

    public void setStudioId(long studioId) {
        this.studioId = studioId;
    }

    public long getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(long photographerId) {
        this.photographerId = photographerId;
    }

    public CommentDTO(Comment comment) {
        this.userName = comment.getCustomerInfo().getFullName();
        this.accountId = comment.getCustomerInfo().getId();
        if(comment.getAlbum() != null){
            this.albumId = comment.getAlbum().getId();
        }
        if(comment.getProduct() != null){
            this.productId = comment.getProduct().getId();
        }
        if(comment.getPhotographerInfo() != null){
            this.photographerId = comment.getPhotographerInfo().getId();
        }
        if(comment.getStudioInfo() != null){
            this.studioId = comment.getStudioInfo().getId();
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
