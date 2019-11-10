package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private float price;
    private long durationInDay;
    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserInfo> userInfoSet;
    private int status;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;

    public Level() {
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getDurationInDay() {
        return durationInDay;
    }

    public void setDurationInDay(long durationInDay) {
        this.durationInDay = durationInDay;
    }

    public Set<UserInfo> getUserInfoSet() {
        return userInfoSet;
    }

    public void setUserInfoSet(Set<UserInfo> userInfoSet) {
        this.userInfoSet = userInfoSet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
