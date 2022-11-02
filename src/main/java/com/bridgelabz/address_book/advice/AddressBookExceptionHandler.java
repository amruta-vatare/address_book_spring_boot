package com.bridgelabz.address_book.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.address_book.controllers.model.ContactResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class AddressBookExceptionHandler {
    private static final String ERROR_MSG = "ERROR WHILE PROCESSING REST REQUEST";
     
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ContactResponse> handleEmployeePayrollException(AddressBookException exception){
        ContactResponse response = new ContactResponse(ERROR_MSG,exception.getMessage());
        return new ResponseEntity<ContactResponse>(response, HttpStatus.BAD_REQUEST);
    } 
    
}
