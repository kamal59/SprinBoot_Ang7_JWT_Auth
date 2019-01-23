package com.training.jwt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ActivityBO implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	private String description;
	
	private String information;

	@Override
	public String toString() {
		return "ActivityBO [id=" + id + ", startDate=" + startDate
				+ ", description=" + description + ", information="
				+ information + "]";
	}

	public ActivityBO(Date startDate, String description, String information) {
		super();
		this.startDate = startDate;
		this.description = description;
		this.information = information;
	}
	
	

}
