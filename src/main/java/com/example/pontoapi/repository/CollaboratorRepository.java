package com.example.pontoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pontoapi.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

}
