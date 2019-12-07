package com.fpt.t1708e.photoplatform.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
public class Level {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(columnDefinition = "text")
	private String description;
	private float price;
	private long durationInDay;
	@OneToMany(mappedBy = "level", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<StudioInfo> studioInfoSet;
	@OneToMany(mappedBy = "level", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<PhotographerInfo> photographerInfoSet;
	private int status;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate deletedAt;

	public Level() {
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

	public Set<StudioInfo> getStudioInfoSet() {
		return studioInfoSet;
	}

	public void setStudioInfoSet(Set<StudioInfo> studioInfoSet) {
		this.studioInfoSet = studioInfoSet;
	}

	public Set<PhotographerInfo> getPhotographerInfoSet() {
		return photographerInfoSet;
	}

	public void setPhotographerInfoSet(Set<PhotographerInfo> photographerInfoSet) {
		this.photographerInfoSet = photographerInfoSet;
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
