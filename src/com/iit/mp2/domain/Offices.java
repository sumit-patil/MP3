package com.iit.mp2.domain;

import java.io.Serializable;

import com.iit.mp2.util.Utility;
/*
 * This is the POJO class for Offices file
 * It contains methods: toString, hashCode() and equals, getters and setters 
 */
public class Offices implements Serializable {
	
	private static final long serialVersionUID = 1213690936707697725L;
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
		
	public Offices(String[] values) {
		super();
		this.officeCode = Utility.checkString(values[0]);
		this.city = Utility.checkString(values[1]);
		this.phone = Utility.checkString(values[2]);
		this.addressLine1 = Utility.checkString(values[3]);
		this.addressLine2 = Utility.checkString(values[4]);
		this.state = Utility.checkString(values[5]);
		this.country = Utility.checkString(values[6]);
		this.postalCode = Utility.checkString(values[7]);
		this.territory = Utility.checkString(values[8]);
	}

	public Offices(String officeCode, String city, String phone,
			String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}



	public String getOfficeCode() {
		return officeCode;
	}



	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddressLine1() {
		return addressLine1;
	}



	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}



	public String getAddressLine2() {
		return addressLine2;
	}



	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getTerritory() {
		return territory;
	}



	public void setTerritory(String territory) {
		this.territory = territory;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result
				+ ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((officeCode == null) ? 0 : officeCode.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((territory == null) ? 0 : territory.hashCode());
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
		Offices other = (Offices) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (officeCode == null) {
			if (other.officeCode != null)
				return false;
		} else if (!officeCode.equals(other.officeCode))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (territory == null) {
			if (other.territory != null)
				return false;
		} else if (!territory.equals(other.territory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offices [officeCode=" + officeCode + ", city=" + city
				+ ", phone=" + phone + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", state=" + state
				+ ", country=" + country + ", postalCode=" + postalCode
				+ ", territory=" + territory + "]";
	}
}
