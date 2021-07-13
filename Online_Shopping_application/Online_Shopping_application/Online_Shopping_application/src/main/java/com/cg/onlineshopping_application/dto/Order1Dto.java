package com.cg.onlineshopping_application.dto;

import java.time.LocalDate;

public class Order1Dto {
	
	private Integer ordId;
	private String ordStatus;
	private LocalDate ordDate;
	private Integer customerId;
	private Integer addressId;
	private Integer productId;
	
	public Order1Dto() {
		super();
	}

	public Order1Dto(Integer ordId, String ordStatus, LocalDate ordDate, Integer customerId, Integer addressId,
			Integer productId) {
		super();
		this.ordId = ordId;
		this.ordStatus = ordStatus;
		this.ordDate = ordDate;
		this.customerId = customerId;
		this.addressId = addressId;
		this.productId = productId;
	}

	public Order1Dto(String ordStatus, LocalDate ordDate, Integer customerId, Integer addressId, Integer productId) {
		super();
		this.ordStatus = ordStatus;
		this.ordDate = ordDate;
		this.customerId = customerId;
		this.addressId = addressId;
		this.productId = productId;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	
}