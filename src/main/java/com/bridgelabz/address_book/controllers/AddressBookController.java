package com.bridgelabz.address_book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.address_book.controllers.model.ContactRequest;
import com.bridgelabz.address_book.controllers.model.ContactResponse;
import com.bridgelabz.address_book.controllers.model.Mapper;
import com.bridgelabz.address_book.services.IAddressBookService;
import com.bridgelabz.address_book.services.model.ContactDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class AddressBookController {
    @Autowired
    IAddressBookService service;

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody @Valid ContactRequest contactRequest){
        ContactDTO dto = Mapper.toService(contactRequest);
        String token = service.addContact(dto);      
        //"New contact was added successfully. (CODE 201)\n"  
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(token+" \nNew contact was added successfully. (CODE 201)\n");
    }
    
    
    @GetMapping("get/{token}")
    public ResponseEntity<ContactResponse> getContact(@PathVariable String token) {
        ContactDTO contactDto =  service.getContact(token);
        ContactResponse contactResponse =   Mapper.fromService(contactDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(contactResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactResponse>> getAllContacts() {
        List<ContactDTO> contactDto =  service.getAllContacts();
        List<ContactResponse> contactResponse =  Mapper.fromService(contactDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(contactResponse);
    }

    @DeleteMapping("remove/{token}")
    public ResponseEntity<String> deleteContact(@PathVariable String token) {
       service.deleteContact(token);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("Contact was deleted successfully. (CODE 201)\n");
    }
    
    @PutMapping("edit/{token}")
    public ResponseEntity<String> updateContact(@PathVariable String token,@RequestBody ContactRequest contactRequest) {
        ContactDTO contactDto = Mapper.toService(contactRequest);
        service.updateContact(token,contactDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("Contact was updated successfully. (CODE 201)\n");
    }
    @GetMapping("mail/{mail}")
    public ResponseEntity<ContactResponse> getContactByMail(@PathVariable String mail) {
        ContactDTO contactDto =  service.getContactByMail(mail);
        ContactResponse contactResponse =   Mapper.fromService(contactDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(contactResponse);
    }
}
