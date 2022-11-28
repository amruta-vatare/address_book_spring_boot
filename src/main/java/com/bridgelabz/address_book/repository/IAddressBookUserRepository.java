package com.bridgelabz.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bridgelabz.address_book.repository.model.AddressBookUser;

@Repository
public interface IAddressBookUserRepository extends JpaRepository<AddressBookUser,String> {
    @Query(value = "select * from address_book_user user where user.email=:email_id",nativeQuery = true)
    AddressBookUser findUserByEmail(@Param("email_id") String email_id);
}
