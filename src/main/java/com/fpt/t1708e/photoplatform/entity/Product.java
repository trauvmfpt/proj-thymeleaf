package com.fpt.t1708e.photoplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "studioInfoId")
	private StudioInfo studioInfo;
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "photographerInfoId")
	private PhotographerInfo photographerInfo;
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Category category;
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "albumId")
	private Album album;
	private String name;
	@Column(columnDefinition = "text")
	private String description;
	@Column(columnDefinition = "text")
	private String content;
	private double price;
	private double priceDiscount;
	private String area;
	private String destination;
	private String thumbnail;
	private double averageRate;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratingSet;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetailSet;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> commentSet;
	@JsonIgnore
	@ManyToMany(mappedBy = "productSet", cascade = { CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Set<Promotion> promotionSet;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;
	private int status; // 1: active 0: deactive  2: is Promoting

	public Product() {
		this.createdAt = LocalDate.now();
		this.updatedAt = LocalDate.now();
		this.status = 1;
	}

	public double getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceDiscount() {
		return priceDiscount;
	}

	public void setPriceDiscount(double priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Set<Rating> getRatingSet() {
		return ratingSet;
	}

	public void setRatingSet(Set<Rating> ratingSet) {
		this.ratingSet = ratingSet;
	}

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}

	public Set<Promotion> getPromotionSet() {
		return promotionSet;
	}

	public void setPromotionSet(Set<Promotion> promotionSet) {
		this.promotionSet = promotionSet;
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
