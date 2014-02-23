package com.iit.mp2.domain;

import java.io.Serializable;

import com.iit.mp2.util.Utility;
/*
 * This is the POJO class for ProductLines file
 * It contains methods: toString, hashCode() and equals, getters and setters 
 */
public class ProductLines implements Serializable {

	
	private static final long serialVersionUID = -7230741636681958240L;
	private String productLine;
	private String textDescription;
	
	public ProductLines(String values[]) {
		super();
		this.productLine = Utility.checkString(values[0]);
		this.textDescription = Utility.checkString(values[1]);
	}



	public ProductLines(String productLine, String textDescription) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
	}



	public String getProductLine() {
		return productLine;
	}



	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}



	public String getTextDescription() {
		return textDescription;
	}



	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productLine == null) ? 0 : productLine.hashCode());
		result = prime * result
				+ ((textDescription == null) ? 0 : textDescription.hashCode());
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
		ProductLines other = (ProductLines) obj;
		if (productLine == null) {
			if (other.productLine != null)
				return false;
		} else if (!productLine.equals(other.productLine))
			return false;
		if (textDescription == null) {
			if (other.textDescription != null)
				return false;
		} else if (!textDescription.equals(other.textDescription))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ProductLines [productLine=" + productLine
				+ ", textDescription=" + textDescription + "]";
	}
	
	
}
