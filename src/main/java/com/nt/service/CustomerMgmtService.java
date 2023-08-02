package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Customer;
import com.nt.repo.ICustomerRepo;

@Service
public class CustomerMgmtService implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo custRepo;

	@Override
	public String createCustomer(Customer cust) {
		cust.setCustId(UUID.randomUUID().toString());
		Customer customer = custRepo.save(cust);
		return "New Customer added with details" + customer;
	}

	@Override
	public String deleteCustomer(String custId) {
		custRepo.deleteById(custId);
		return "Customer deleted with id" + custId;
	}

	@Override
	public List<Customer> getCustomerList() {
		return custRepo.findAll();
	}

	@Override
	public String updateCustomer(Customer cust) {
		Optional<Customer> optCust=custRepo.findById(cust.getCustId());
		Customer customer=optCust.get();
		customer.setFirstName(cust.getFirstName());
		customer.setLastName(cust.getLastName());
		customer.setStreet(cust.getStreet());
		customer.setAddress(cust.getAddress());
		customer.setCity(cust.getCity());
		customer.setEmail(cust.getEmail());
		customer.setPhone(cust.getPhone());
		
		String msg=custRepo.save(customer).getCustId();
		
		return "Customer details update with id"+msg;
		
	}

}
