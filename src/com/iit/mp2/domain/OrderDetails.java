package com.iit.mp2.domain;

import java.io.Serializable;

import com.iit.mp2.util.Utility;
/*
 * This is the POJO class for Offices file
 * It contains methods: toString, hashCode() and equals, getters and setters 
 */
public class OrderDetails implements Serializable {
	
	private static final long serialVersionUID = 5528104526804207932L;
	private Integer orderNumber;
	private String productCode;
	private Integer quantityOrdered;
	private Double priceEach;
	private Integer orderLineNumber;
	
	public OrderDetails(String values[]) {
		super();
		this.orderNumber = Utility.checkInteger(values[0]);
		this.productCode = Utility.checkString(values[1]);
		this.quantityOrdered = Utility.checkInteger(values[2]);
		this.priceEach = Utility.checkDouble(values[3]);
		this.orderLineNumber = Utility.checkInteger(values[4]);
	}

	public OrderDetails(Integer orderNumber, String productCode,
			Integer quantityOrdered, Double priceEach, Integer orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(Double priceEach) {
		this.priceEach = priceEach;
	}

	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderLineNumber == null) ? 0 : orderLineNumber.hashCode());
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result
				+ ((priceEach == null) ? 0 : priceEach.hashCode());
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result
				+ ((quantityOrdered == null) ? 0 : quantityOrdered.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (orderLineNumber == null) {
			if (other.orderLineNumber != null)
				return false;
		} else if (!orderLineNumber.equals(other.orderLineNumber))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (priceEach == null) {
			if (other.priceEach != null)
				return false;
		} else if (!priceEach.equals(other.priceEach))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (quantityOrdered == null) {
			if (other.quantityOrdered != null)
				return false;
		} else if (!quantityOrdered.equals(other.quantityOrdered))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "OrderDetails [orderNumber=" + orderNumber + ", productCode="
				+ productCode + ", quantityOrdered=" + quantityOrdered
				+ ", priceEach=" + priceEach + ", orderLineNumber="
				+ orderLineNumber + "]";
	}
	
	
	
}
