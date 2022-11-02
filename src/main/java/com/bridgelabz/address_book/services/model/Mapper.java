package com.bridgelabz.address_book.services.model;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.address_book.repository.model.ContactData;

public class Mapper {
    public static ContactDTO fromRepository(ContactData contact){
        ContactDTO dto = new ContactDTO();
        dto.setFullName(contact.getFullName());
        dto.setAddress(contact.getAddress());
        dto.setPhoneNumber(contact.getPhoneNumber());
        dto.setCity(contact.getCity());
        dto.setZipCode(contact.getZipCode());
        dto.setState(contact.getState());
        dto.setEmail(contact.getEmail());
        return dto;
    }

    public static ContactData toRepository(ContactDTO dto){
        ContactData contact = new ContactData();
        contact.setFullName(dto.getFullName());
        contact.setAddress(dto.getAddress());
        contact.setCity(dto.getCity());
        contact.setState(dto.getState());
        contact.setZipCode(dto.getZipCode());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        return contact;

    }

    public static List<ContactDTO> fromRepository(List<ContactData> contacts) {
        List<ContactDTO> dtos = new ArrayList<>();
        for (ContactData contactDTO : contacts) {
            ContactDTO contact = new ContactDTO();
            contact.setFullName(contactDTO.getFullName());
            contact.setAddress(contactDTO.getAddress());
            contact.setCity(contactDTO.getCity());
            contact.setState(contactDTO.getState());
            contact.setZipCode(contactDTO.getZipCode());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());
            contact.setEmail(contactDTO.getEmail());
            dtos.add(contact);
        }
        return dtos;
    }
}
