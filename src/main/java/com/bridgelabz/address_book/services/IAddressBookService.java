package com.bridgelabz.address_book.services;

import java.util.List;

import com.bridgelabz.address_book.services.model.ContactDTO;

public interface IAddressBookService {

    String addContact(ContactDTO dto);

    ContactDTO getContact(int id);

    List<ContactDTO> getAllContacts();

    void deleteContact(int id);

    void updateContact(int id, ContactDTO contactDto);

    ContactDTO getContactByMail(String mail);
    
}
