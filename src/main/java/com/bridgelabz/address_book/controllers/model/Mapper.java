package com.bridgelabz.address_book.controllers.model;

import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.address_book.services.model.ContactDTO;

public class Mapper {
    public static ContactResponse fromService(ContactDTO dto){
        ContactResponse response = new ContactResponse();
        response.setFullName(dto.getFullName());
        response.setPhoneNumber(dto.getPhoneNumber());
        response.setAddress(dto.getAddress());
        response.setCity(dto.getCity());
        response.setState(dto.getState());
        response.setZipCode(dto.getZipCode());
        response.setEmail(dto.getEmail());
        return response;
    }

    public static ContactDTO toService(ContactRequest request){
        ContactDTO dto = new ContactDTO();
        dto.setFullName(request.getFullName());
        dto.setPhoneNumber(request.getPhoneNumber());
        dto.setAddress(request.getAddress());
        dto.setCity(request.getCity());
        dto.setState(request.getState());
        dto.setZipCode(request.getZipCode());
        dto.setEmail(request.getEmail());
        return dto;
    }

    public static List<ContactResponse> fromService(List<ContactDTO> contactDtos) {
        List<ContactResponse> responses = new ArrayList<>();
        for (ContactDTO contactDto : contactDtos) {
            ContactResponse response = new ContactResponse();
            response.setFullName(contactDto.getFullName());
            response.setPhoneNumber(contactDto.getPhoneNumber());
            response.setAddress(contactDto.getAddress());
            response.setCity(contactDto.getCity());
            response.setState(contactDto.getState());
            response.setZipCode(contactDto.getZipCode());
            response.setEmail(contactDto.getEmail());
            responses.add(response);
        }
        return responses;
    }
}
