package com.bridgelabz.address_book.controllers.model;

import lombok.Data;

@Data
public class ContactResponse {
    public ContactResponse(String errorMsg, String message) {
    }
    private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;

	private String token;
	private int id;
	public ContactResponse(){};
}
