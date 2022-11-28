package com.bridgelabz.address_book.services.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String email;
    private String password;
}
