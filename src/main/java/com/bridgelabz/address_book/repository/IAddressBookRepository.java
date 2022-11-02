package com.bridgelabz.address_book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bridgelabz.address_book.repository.model.ContactData;

@Repository
public interface IAddressBookRepository extends JpaRepository<ContactData,Integer>{
    @Query(value = "select * from contact_data contact where contact.email=:email_id",nativeQuery = true)
    ContactData findContactByEmail(@Param("email_id") String email_id);
    
}
