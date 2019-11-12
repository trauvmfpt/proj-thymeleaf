package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private int role;    // 1: customer 2: studio 3: admin
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInfo userInfo;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Album> albumSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderProduct> orderProductSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Promotion> promotionSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> productSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rating> ratingSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rating> ratingSet1;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> commentSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> commentSet1;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private int status;

    public Account() {
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    public Account(String username, String password) {
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }

    public Set<OrderProduct> getOrderProductSet() {
        return orderProductSet;
    }

    public void setOrderProductSet(Set<OrderProduct> orderProductSet) {
        this.orderProductSet = orderProductSet;
    }

    public Set<Promotion> getPromotionSet() {
        return promotionSet;
    }

    public void setPromotionSet(Set<Promotion> promotionSet) {
        this.promotionSet = promotionSet;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    public Set<Rating> getRatingSet1() {
        return ratingSet1;
    }

    public void setRatingSet1(Set<Rating> ratingSet1) {
        this.ratingSet1 = ratingSet1;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Set<Comment> getCommentSet1() {
        return commentSet1;
    }

    public void setCommentSet1(Set<Comment> commentSet1) {
        this.commentSet1 = commentSet1;
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
