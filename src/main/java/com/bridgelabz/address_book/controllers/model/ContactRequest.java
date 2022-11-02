package com.bridgelabz.address_book.controllers.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ContactRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String fullName;
    @NotBlank
	private String address;
    @NotNull
	private long phoneNumber;
    @NotBlank
	private String city;
    @NotBlank
	private String state;
    @NotNull
	private int zipCode;
    @NotBlank
    @Email(message = "Email is invalid")
	private String email;
}
