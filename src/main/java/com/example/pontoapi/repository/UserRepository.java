package com.example.pontoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pontoapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
