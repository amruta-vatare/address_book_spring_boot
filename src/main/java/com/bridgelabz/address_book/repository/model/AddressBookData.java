package com.bridgelabz.address_book.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AddressBookData {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "FULL_NAME")
	private String fullName;

    @Column(name = "ADDRESS")
	private String address;

    @Column(name = "PHONE_NO")
	private long phoneNumber;

    @Column(name = "CITY")
	private String city;

    @Column(name = "STATE")
	private String state;

    @Column(name = "ZIP_CODE")
	private int zipCode;

    @Column(name = "EMAIL")
	private String email;
    
}
