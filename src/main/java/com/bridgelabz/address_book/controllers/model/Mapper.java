package com.bridgelabz.address_book.controllers.model;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.address_book.repository.model.AddressBookUser;
import com.bridgelabz.address_book.services.model.ContactDTO;
import com.bridgelabz.address_book.services.model.UserDTO;

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
            
            response.setId(contactDto.getId());
            response.setToken(contactDto.getToken());
            responses.add(response);
        }
        return responses;
    }

    public static UserDTO toService(UserRequest userRequest) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userRequest.getUserName());
        userDTO.setEmail(userRequest.getEmail());
        userDTO.setPassword(userRequest.getPassword());
        return userDTO;
    }

    public static AddressBookUser toRepository(UserDTO userdto) {
        AddressBookUser user = new AddressBookUser();
        user.setUserName(userdto.getUserName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        return user;
    }
}
