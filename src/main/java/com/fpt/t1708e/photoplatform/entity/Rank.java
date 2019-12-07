package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
public class Rank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private float discount;
	@Column(columnDefinition = "text")
	private String description;
	@OneToMany(mappedBy = "rank", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<CustomerInfo> customerInfoSet;
	private long pointRequired;
	private int status;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;

	public Rank() {
		this.createdAt = LocalDate.now();
		this.updatedAt = LocalDate.now();
		this.status = 1;
	}

	public long getPointRequired() {
		return pointRequired;
	}

	public void setPointRequired(long pointRequired) {
		this.pointRequired = pointRequired;
	}

	public Set<CustomerInfo> getCustomerInfoSet() {
		return customerInfoSet;
	}

	public void setCustomerInfoSet(Set<CustomerInfo> customerInfoSet) {
		this.customerInfoSet = customerInfoSet;
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

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
}
