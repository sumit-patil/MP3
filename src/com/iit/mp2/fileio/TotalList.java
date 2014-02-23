package com.iit.mp2.fileio;

import java.io.Serializable;
import java.util.List;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Offices;
import com.iit.mp2.domain.OrderDetails;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.domain.Payments;
import com.iit.mp2.domain.ProductLines;
import com.iit.mp2.domain.Products;
/*
 * This class loads all the list objects into one single list named TotalList, which is further used to serialized
 */
public class TotalList implements Serializable {

	private static final long serialVersionUID = -4845223510066658127L;
	private List<Customers> customers;
	private List<Employees> employees;
	private List<Orders> orders;
	private List<Offices> offices;
	private List<OrderDetails> orderDetails;
	private List<Payments> payments;
	private List<ProductLines> productLines;
	private List<Products> products;

	public void addCustomersList(List<Customers> customers) {
		this.customers = customers;
	}

	public void addEmployeesList(List<Employees> employees) {
		this.employees = employees;
	}

	public void addOrdersList(List<Orders> orders) {
		this.orders = orders;
	}
	
	public void addOfficesList(List<Offices> offices) {
		this.offices = offices;
	}

	public void addOrderDetailsList(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void addPaymentsList(List<Payments> payments) {
		this.payments = payments;
	}
	
	public void addProductLinesList(List<ProductLines> productLines) {
		this.productLines = productLines;
	}
	
	public void addProductsList(List<Products> products) {
		this.products = products;
	}
	//--------------------------

	public List<Customers> getCustomersList()
	{
		return this.customers;
	}
	
	public List<Employees> getEmployeesList()
	{
		return this.employees;
	}
	
	public List<Orders> getOrdersList()
	{
		return this.orders;
	}
	
	public List<Offices> getOfficesList()
	{
		return this.offices;
	}
	
	public List<OrderDetails> getOrderDetailsList()
	{
		return this.orderDetails;
	}
	
	public List<Payments> getPaymentsList()
	{
		return this.payments;
	}
	
	public List<ProductLines> getProductLinesList()
	{
		return this.productLines;
	}
	
	public List<Products> getProductList()
	{
		return this.products;
	}
}
