package com.ija.math;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATHEXPRESSION")
public class MathExpression {
	
	@Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	  
	 @Column(name="OPERATION_DESC")
	 private String operationDesc;
	  
	 @Column(name="RESULT")
	 private Integer result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperationDesc() {
		return operationDesc;
	}

	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}
