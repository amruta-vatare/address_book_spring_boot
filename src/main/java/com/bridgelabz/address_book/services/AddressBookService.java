package com.bridgelabz.address_book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.address_book.advice.AddressBookException;
import com.bridgelabz.address_book.repository.IAddressBookRepository;
import com.bridgelabz.address_book.repository.model.ContactData;
import com.bridgelabz.address_book.services.model.ContactDTO;
import com.bridgelabz.address_book.services.model.Mapper;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    IAddressBookRepository repository;

    @Override
    public void addContact(ContactDTO dto) {
        ContactData contact = Mapper.toRepository(dto);
        repository.save(contact);
    }

    @Override
    public ContactDTO getContact(int id) {
    List<ContactData> contacts  = repository.findAll();
    ContactDTO dto = Mapper.fromRepository(contacts.stream().filter(contact->contact.getId() == id).findFirst().orElseThrow(()->new AddressBookException("Contact is not found!")));
    return dto;
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<ContactData> contacts  = repository.findAll();
        List<ContactDTO> contactDTOs = Mapper.fromRepository(contacts);
        return contactDTOs;
    }

    @Override
    public void deleteContact(int id) {
        ContactData contact = repository.findById(id).get();
        repository.delete(contact);
    }

    @Override
    public void updateContact(int id, ContactDTO contact) {
        ContactData contactData = repository.findById(id).get();
        contactData.setFullName(contact.getFullName());
        contactData.setPhoneNumber(contact.getPhoneNumber());
        contactData.setAddress(contact.getAddress());
        contactData.setCity(contact.getCity());
        contactData.setState(contact.getState());
        contactData.setZipCode(contact.getZipCode());
        contactData.setEmail(contact.getEmail());
        repository.save(contactData);
    }

    
}
