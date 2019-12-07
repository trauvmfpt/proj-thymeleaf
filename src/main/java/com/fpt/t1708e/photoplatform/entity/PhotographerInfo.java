package com.fpt.t1708e.photoplatform.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PhotographerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;
	private String fullName;
	private String address;
	private String phone;
	private String email;
	private LocalDate birthday;
	private int gender;
	private double averageRate;
	@Column(columnDefinition = "text")
	private String description;
	private String avatar;
	private Date levelExpiredAt;
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "levelId")
	private Level level;
	@ManyToOne(cascade = { CascadeType.MERGE})
	@JoinColumn(name = "StudioInfoId")
	private StudioInfo studioInfo;
	@OneToMany(mappedBy = "photographerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Album> albumSet;
	@OneToMany(mappedBy = "photographerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> productSet;
	@OneToMany(mappedBy = "photographerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratingSet;
	@OneToMany(mappedBy = "photographerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> commentSet;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;
	private int status;

	public PhotographerInfo() {
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getLevelExpiredAt() {
		return levelExpiredAt;
	}

	public void setLevelExpiredAt(Date levelExpiredAt) {
		this.levelExpiredAt = levelExpiredAt;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public StudioInfo getStudioInfo() {
		return studioInfo;
	}

	public void setStudioInfo(StudioInfo studioInfo) {
		this.studioInfo = studioInfo;
	}

	public Set<Album> getAlbumSet() {
		return albumSet;
	}

	public void setAlbumSet(Set<Album> albumSet) {
		this.albumSet = albumSet;
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
