package com.iit.mp2.domain;

import java.io.Serializable;

import com.iit.mp2.util.Utility;
/*
 * This is the POJO class for Products file
 * It contains methods: toString, hashCode() and equals, getters and setters 
 */
public class Products implements Serializable {

	private static final long serialVersionUID = 6721083524595125767L;
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private Integer quantityInStock;
	private Double buyPrice;
	private Double MSRP;
	
	public Products(String values[]) {
		super();
		this.productCode = Utility.checkString(values[0]);
		this.productName = Utility.checkString(values[1]);
		this.productLine = Utility.checkString(values[2]);
		this.productScale = Utility.checkString(values[3]);
		this.productVendor = Utility.checkString(values[4]);
		this.productDescription = Utility.checkString(values[5]);
		this.quantityInStock = Utility.checkInteger(values[6]);
		this.buyPrice = Utility.checkDouble(values[7]);
		this.MSRP = Utility.checkDouble(values[8]);
	}



	public Products(String productCode, String productName, String productLine,
			String productScale, String productVendor,
			String productDescription, Integer quantityInStock,
			Double buyPrice, Double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = mSRP;
	}



	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductLine() {
		return productLine;
	}



	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}



	public String getProductScale() {
		return productScale;
	}



	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}



	public String getProductVendor() {
		return productVendor;
	}



	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public Integer getQuantityInStock() {
		return quantityInStock;
	}



	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}



	public Double getBuyPrice() {
		return buyPrice;
	}



	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}



	public Double getMSRP() {
		return MSRP;
	}



	public void setMSRP(Double mSRP) {
		this.MSRP = mSRP;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MSRP == null) ? 0 : MSRP.hashCode());
		result = prime * result
				+ ((buyPrice == null) ? 0 : buyPrice.hashCode());
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		result = prime
				* result
				+ ((productDescription == null) ? 0 : productDescription
						.hashCode());
		result = prime * result
				+ ((productLine == null) ? 0 : productLine.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((productScale == null) ? 0 : productScale.hashCode());
		result = prime * result
				+ ((productVendor == null) ? 0 : productVendor.hashCode());
		result = prime * result
				+ ((quantityInStock == null) ? 0 : quantityInStock.hashCode());
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
		Products other = (Products) obj;
		if (MSRP == null) {
			if (other.MSRP != null)
				return false;
		} else if (!MSRP.equals(other.MSRP))
			return false;
		if (buyPrice == null) {
			if (other.buyPrice != null)
				return false;
		} else if (!buyPrice.equals(other.buyPrice))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productLine == null) {
			if (other.productLine != null)
				return false;
		} else if (!productLine.equals(other.productLine))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productScale == null) {
			if (other.productScale != null)
				return false;
		} else if (!productScale.equals(other.productScale))
			return false;
		if (productVendor == null) {
			if (other.productVendor != null)
				return false;
		} else if (!productVendor.equals(other.productVendor))
			return false;
		if (quantityInStock == null) {
			if (other.quantityInStock != null)
				return false;
		} else if (!quantityInStock.equals(other.quantityInStock))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Products [productCode=" + productCode + ", productName="
				+ productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor="
				+ productVendor + ", productDescription=" + productDescription
				+ ", quantityInStock=" + quantityInStock + ", buyPrice="
				+ buyPrice + ", MSRP=" + MSRP + "]";
	}
	
	
}
