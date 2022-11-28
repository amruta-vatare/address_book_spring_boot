package com.bridgelabz.address_book.services.model;

import lombok.Data;

@Data
public class ContactDTO {
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;

	private int id;
	private String token;
    public ContactDTO(){};
	
}
