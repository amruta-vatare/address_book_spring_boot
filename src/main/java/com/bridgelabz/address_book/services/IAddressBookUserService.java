package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.services.model.UserDTO;

public interface IAddressBookUserService {

    String addUser(UserDTO userdto);

    String validateUser(UserDTO userdto);
    
}
