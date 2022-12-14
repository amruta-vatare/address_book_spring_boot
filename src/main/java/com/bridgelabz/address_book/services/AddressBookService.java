package com.bridgelabz.address_book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import com.bridgelabz.address_book.advice.AddressBookException;
import com.bridgelabz.address_book.advice.ValidationException;
import com.bridgelabz.address_book.repository.IAddressBookRepository;
import com.bridgelabz.address_book.repository.model.ContactData;
import com.bridgelabz.address_book.security.EmailSenderService;
import com.bridgelabz.address_book.security.JwtUtil;
import com.bridgelabz.address_book.services.model.ContactDTO;
import com.bridgelabz.address_book.services.model.Mapper;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    private IAddressBookRepository repository;

    @Autowired
    EmailSenderService senderService;

    @Autowired
    private JwtUtil util;

    @Override
    public String addContact(ContactDTO dto)throws ValidationException {
        ContactData contact = Mapper.toRepository(dto);
        int count = repository.isContactIsPresent(contact.getEmail(),contact.getPhoneNumber());
        if(count > 0){
            throw new ValidationException("User with email "+contact.getEmail()+" and phone number "+contact.getPhoneNumber()+" is already exist");
        }
        repository.save(contact);
        String token = util.generateToken(contact.getId());
        try{
            senderService.sendEmail(contact.getEmail(), "Token authentication", "Hello, "+contact.getFullName()+"\n"+token);
        }catch(Exception e){
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public ContactDTO getContact(String token) {
    int id = util.decodeToken(token);
    List<ContactData> contacts  = repository.findAll();
    ContactDTO dto = Mapper.fromRepository(contacts.stream().filter(contact->contact.getId() == id).findFirst().orElseThrow(()->new AddressBookException("Contact is not found!")));
    return dto;
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<ContactData> contacts  = repository.findAll();
        List<ContactDTO> contactDTOs = Mapper.fromRepository(contacts);
        for (ContactDTO contactDTO : contactDTOs) {
            contactDTO.setToken(util.generateToken(contactDTO.getId()));
        }
        return contactDTOs;
    }

    @Override
    public void deleteContact(String token) {
        int id = util.decodeToken(token);
        ContactData contact = repository.findById(id).get();
        repository.delete(contact);
        //senderService.sendEmail(contact.getEmail(), "Confirmation authentication", "Hello, "+contact.getFullName()+"\n"+token+"\n the contact was deleted successfully!");
    }

    @Override
    public void updateContact(String token, ContactDTO contact) {
        int id = util.decodeToken(token);
        ContactData contactData = repository.findById(id).get();
        contactData.setFullName(contact.getFullName());
        contactData.setPhoneNumber(contact.getPhoneNumber());
        contactData.setAddress(contact.getAddress());
        contactData.setCity(contact.getCity());
        contactData.setState(contact.getState());
        contactData.setZipCode(contact.getZipCode());
        contactData.setEmail(contact.getEmail());
        repository.save(contactData);
        //senderService.sendEmail(contact.getEmail(), "Confirmation authentication", "Hello, "+contact.getFullName()+"\n"+token+"\n the contact was updated successfully!");
    }

    @Override
    public ContactDTO getContactByMail(String mail) {
        ContactData contact = repository.findContactByEmail(mail);
        ContactDTO dto = Mapper.fromRepository(contact);
        return dto;
    }

    @Override
    public List<ContactDTO> getContactsByOrder(String sortCol, Direction sortDirection) {
        
        List<ContactData> list = repository.getSortedContacts(JpaSort.unsafe(sortDirection,sortCol));
        // List<ContactData> list = repository.getSortedContacts(PageRequest.of(0, 1000000, Sort.Direction.DESC, sortColumn));
        return Mapper.fromRepository(list);
    }

    @Override
    public List<ContactDTO> getContactsBySearchString(String searchString) {
        List<ContactData> data = repository.findContactsBySearchString(searchString);
        return Mapper.fromRepository(data);
    }

    
    
}
         