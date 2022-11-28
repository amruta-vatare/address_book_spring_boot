package com.bridgelabz.address_book.controllers.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String userName;
    private String email;
    private String password;
}
