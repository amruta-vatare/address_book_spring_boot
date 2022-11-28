package com.bridgelabz.address_book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.address_book.controllers.model.Mapper;
import com.bridgelabz.address_book.controllers.model.UserRequest;
import com.bridgelabz.address_book.controllers.model.UserResponse;
import com.bridgelabz.address_book.services.IAddressBookUserService;
import com.bridgelabz.address_book.services.model.UserDTO;

@Controller
@CrossOrigin
@RequestMapping("/addressBookUser")
public class AddressBookUserController {

    @Autowired
    IAddressBookUserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest){
        UserDTO userdto = Mapper.toService(userRequest);
        String response= userService.addUser(userdto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);

    }

    @GetMapping("/validateUser")
    public ResponseEntity<String> validateUser(@RequestBody UserRequest userRequest){
        UserDTO userdto = Mapper.toService(userRequest);
        String tokenString = userService.validateUser(userdto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(tokenString);
    }
}
