package com.iit.mp2.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.iit.mp2.util.Utility;
/*
 * This is the POJO class for Payments file
 * It contains methods: toString, hashCode() and equals, getters and setters 
 */
public class Payments implements Serializable {

	private static final long serialVersionUID = 8940024366553322733L;
	private Integer customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private Double amount;
	
	public Payments(String values[]) throws ParseException {
		super();
		this.customerNumber = Utility.checkInteger(values[0]);
		this.checkNumber = Utility.checkString(values[1]);
		this.paymentDate = Utility.getDateFromString(values[2]);
		this.amount = Utility.checkDouble(values[3]);
	}

	public Payments(Integer customerNumber, String checkNumber,
			Date paymentDate, Double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result
				+ ((customerNumber == null) ? 0 : customerNumber.hashCode());
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
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
		Payments other = (Payments) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (checkNumber == null) {
			if (other.checkNumber != null)
				return false;
		} else if (!checkNumber.equals(other.checkNumber))
			return false;
		if (customerNumber == null) {
			if (other.customerNumber != null)
				return false;
		} else if (!customerNumber.equals(other.customerNumber))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payments [customerNumber=" + customerNumber + ", checkNumber="
				+ checkNumber + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	} 	
}
