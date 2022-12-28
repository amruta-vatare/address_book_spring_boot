package com.bridgelabz.address_book.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bridgelabz.address_book.repository.model.ContactData;

@Repository
public interface IAddressBookRepository extends JpaRepository<ContactData,Integer>{
    @Query(value = "select * from contact_data contact where contact.email=:email_id",nativeQuery = true)
    ContactData findContactByEmail(@Param("email_id") String email_id);

    @Query(value = "select count(id) from contact_data contact where contact.email=:email_id or contact.phone_no=:phoneNumber",nativeQuery = true)
    int isContactIsPresent(@Param("email_id") String email_id,long phoneNumber);

    @Query("from ContactData")
    List<ContactData> getSortedContacts(Sort sort);
    //List<ContactData> getSortedContacts(Pageable p);

    @Query(value = "select * from contact_data contact where contact.full_Name LIKE %:searchString% or contact.city LIKE %:searchString% or contact.state LIKE %:searchString% or contact.phone_no LIKE %:searchString%",nativeQuery = true)
    List<ContactData> findContactsBySearchString(@Param("searchString") String searchString);

    
}
