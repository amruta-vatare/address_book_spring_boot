package com.bridgelabz.address_book.services;

import java.util.List;

import com.bridgelabz.address_book.services.model.ContactDTO;

public interface IAddressBookService {

    void addContact(ContactDTO dto);

    ContactDTO getContact(int id);

    List<ContactDTO> getAllContacts();

    void deleteContact(int id);

    void updateContact(int id, ContactDTO contactDto);
    
}
