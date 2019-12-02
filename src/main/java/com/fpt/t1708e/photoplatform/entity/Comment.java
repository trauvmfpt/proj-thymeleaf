package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Comment {
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
	@Column(columnDefinition = "text")
	private String content;
	private long createdAt;
	private long updatedAt;
	private long deletedAt;
	private int status;

	public Comment() {
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
