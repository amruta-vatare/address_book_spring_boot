package com.bridgelabz.address_book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.address_book.controllers.model.Mapper;
import com.bridgelabz.address_book.controllers.model.UserRequest;
import com.bridgelabz.address_book.repository.IAddressBookUserRepository;
import com.bridgelabz.address_book.repository.model.AddressBookUser;
import com.bridgelabz.address_book.security.JwtUtil;
import com.bridgelabz.address_book.services.model.UserDTO;

@Service
public class AddressBookUserService implements IAddressBookUserService {

    @Autowired
    IAddressBookUserRepository repository;

    
    @Autowired
    private JwtUtil util;

    @Override
    public String addUser(UserDTO userdto) {
        AddressBookUser user = Mapper.toRepository(userdto);
        AddressBookUser respnseUser = repository.save(user);
       if(respnseUser != null){
        return "User was added successfully!";
       }
        return "Registration is failed!";
    }

    @Override
    public String validateUser(UserDTO userdto) {
        AddressBookUser user = repository.findUserByEmail(userdto.getEmail());
        if( userdto.getEmail().equals(user.getEmail()) && userdto.getPassword().equals(user.getPassword())){
            String token = util.generateUserToken(user.getUserName());
            if(token!= null){
                return token;
            }
        }
        
        return "Login fail!";
    }
    
    
}
