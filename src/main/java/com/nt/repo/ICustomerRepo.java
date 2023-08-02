package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, String> {

}
