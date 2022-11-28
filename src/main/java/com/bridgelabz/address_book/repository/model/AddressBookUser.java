package com.bridgelabz.address_book.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AddressBookUser {
    @Id
    @Column(name = "userName")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="passowrd")
    private String password;

}
