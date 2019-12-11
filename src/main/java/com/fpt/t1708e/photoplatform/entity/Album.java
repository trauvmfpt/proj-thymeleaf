package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "studioInfoId")
	private StudioInfo studioInfo;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "photographerInfoId")
	private PhotographerInfo photographerInfo;
	private String name;
	private String description;
	private String thumbnail;
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> productSet;
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratingSet;
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> commentSet;
	@OneToMany(mappedBy = "album", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<Picture> pictureSet;
	private double averageRate;
	private long numberOfRate;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;
	private int status;

	public Album() {
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

	public long getNumberOfRate() {
		return numberOfRate;
	}

	public void setNumberOfRate(long numberOfRate) {
		this.numberOfRate = numberOfRate;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}

	public Set<Picture> getPictureSet() {
		return pictureSet;
	}

	public void setPictureSet(Set<Picture> pictureSet) {
		this.pictureSet = pictureSet;
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
