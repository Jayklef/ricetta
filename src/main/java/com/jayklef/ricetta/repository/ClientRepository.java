package com.jayklef.ricetta.repository;

import com.jayklef.ricetta.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByName(String name);
}
