package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	private String custId;
	@Column(length = 20,nullable = false)
	private String firstName;
	@Column(length = 20,nullable = false)
	private String lastName;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phone;
	
}
