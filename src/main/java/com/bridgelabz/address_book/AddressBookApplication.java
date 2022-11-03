package com.bridgelabz.address_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

}
