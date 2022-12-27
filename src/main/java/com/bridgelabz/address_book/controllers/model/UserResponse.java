package com.bridgelabz.address_book.controllers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
    private String email;
    private String token;
}
