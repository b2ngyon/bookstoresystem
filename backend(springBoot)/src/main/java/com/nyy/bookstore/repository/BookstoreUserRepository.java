package com.nyy.bookstore.repository;

import com.nyy.bookstore.entity.BookstoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookstoreUserRepository extends JpaRepository<BookstoreUser,Integer> {

    public BookstoreUser findByUserName(String username);
}
