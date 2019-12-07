package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "customerInfoId")
	private CustomerInfo customerInfo;
	private float value;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "albumId")
	private Album album;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "productId")
	private Product product;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "studioInfoId")
	private StudioInfo studioInfo;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "photographerInfoId")
	private PhotographerInfo photographerInfo;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;
	private int status;

	public Rating() {
		this.createdAt = LocalDate.now();
		this.updatedAt = LocalDate.now();
		this.status = 1;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
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
