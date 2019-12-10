package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AdminRevenueDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "adminRevenueId")
    private AdminRevenue adminRevenue;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "studioInfoId")
    private StudioInfo studioInfo;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "photographerInfoId")
    private PhotographerInfo photographerInfo;
    private double currentPrice;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
    private int status; // 0. new, 1. da huy, 2.cho xac nhan, 3. da xac nhan

    public AdminRevenueDetail() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.status = 0;
    }

    public AdminRevenueDetail(Product product, double currentPrice) {
        this.product = product;
        this.currentPrice = product.getPriceDiscount();
        this.status = 0;
    }

    public StudioInfo getStudioInfo() {
        return studioInfo;
    }

    public void setStudioInfo(StudioInfo studioInfo) {
        this.studioInfo = studioInfo;
    }

    public PhotographerInfo getPhotographerInfo() {
        return photographerInfo;
    }

    public void setPhotographerInfo(PhotographerInfo photographerInfo) {
        this.photographerInfo = photographerInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdminRevenue getAdminRevenue() {
        return adminRevenue;
    }

    public void setAdminRevenue(AdminRevenue adminRevenue) {
        this.adminRevenue = adminRevenue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
