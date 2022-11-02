package com.bridgelabz.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.address_book.repository.model.ContactData;

@Repository
public interface IAddressBookRepository extends JpaRepository<ContactData,Integer>{
    
}
