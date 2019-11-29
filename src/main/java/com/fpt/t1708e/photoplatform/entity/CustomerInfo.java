package com.fpt.t1708e.photoplatform.entity;

import java.util.Calendar;
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
public class CustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;
	private String fullName;
	private String address;
	private String phone;
	private long birthday;
	private int gender;
	private String email;
	@Column(columnDefinition = "text")
	private String description;
	private String avatar;
	@ManyToOne(cascade = { CascadeType.MERGE})
	@JoinColumn(name = "rankId")
	private Rank rank;
	@OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderProduct> orderProductSet;
	@OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratingSet;
	@OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> commentSet;
	private long totalPoint;
	private long createdAt;
	private long updatedAt;
	private long deletedAt;
	private int status;

	public CustomerInfo() {
		this.createdAt = Calendar.getInstance().getTimeInMillis();
		this.updatedAt = Calendar.getInstance().getTimeInMillis();
		this.status = 1;
	}

	public long getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(long totalPoint) {
		this.totalPoint = totalPoint;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
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

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Set<OrderProduct> getOrderProductSet() {
		return orderProductSet;
	}

	public void setOrderProductSet(Set<OrderProduct> orderProductSet) {
		this.orderProductSet = orderProductSet;
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
