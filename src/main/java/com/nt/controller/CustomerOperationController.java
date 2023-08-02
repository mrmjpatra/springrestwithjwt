package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {
	@Autowired
	private ICustomerMgmtService service;

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = service.getCustomerList();
		System.out.println("CustomerOperationController.getAllCustomers()");
		System.out.println(customers);
		return ResponseEntity.ok(customers);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		String msg = service.createCustomer(customer);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String custId) {
		String msg = service.deleteCustomer(custId);
		return ResponseEntity.ok(msg);
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		String msg = service.updateCustomer(customer);
		return ResponseEntity.ok(msg);
	}
}
