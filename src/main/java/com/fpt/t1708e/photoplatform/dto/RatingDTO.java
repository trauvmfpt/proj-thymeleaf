package com.fpt.t1708e.photoplatform.dto;

import com.fpt.t1708e.photoplatform.entity.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

public class RatingDTO {
    private float value;
    private long albumId;
    private long productId;
    private long studioId;
    private long accountId;
    private long photographerId;

    public RatingDTO() {
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
