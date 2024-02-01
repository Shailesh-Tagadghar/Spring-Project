package com.example.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
