package com.nt.service;

import java.util.List;

import com.nt.model.Customer;

public interface ICustomerMgmtService {
	public String createCustomer(Customer cust);
	public List<Customer> getCustomerList();
	public String deleteCustomer(String custId);
	public String updateCustomer(Customer cust);
}
