package com.training.jwt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OperationBO implements Serializable {

	@Id @GeneratedValue
	private Long id;
	
	@Column(name="OPERATION_DATE")
	private Date operationDate;
	
	@Column(name="OPERATION_VALUE")
	private Long op_value;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.STRING)
	private TypeEnum type; 
		
	private String description;
	
	private String origin_destination_name;

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Long getOp_value() {
		return op_value;
	}

	public void setOp_value(Long op_value) {
		this.op_value = op_value;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin_destination_name() {
		return origin_destination_name;
	}

	public void setOrigin_destination_name(String origin_destination_name) {
		this.origin_destination_name = origin_destination_name;
	}
}
