package com.bridgelabz.address_book.services;

import java.util.List;

import com.bridgelabz.address_book.advice.ValidationException;
import com.bridgelabz.address_book.services.model.ContactDTO;

public interface IAddressBookService {

    String addContact(ContactDTO dto) throws ValidationException;

    ContactDTO getContact(String token);

    List<ContactDTO> getAllContacts();

    void deleteContact(String token);

    void updateContact(String token, ContactDTO contactDto);

    ContactDTO getContactByMail(String mail);
    
}
