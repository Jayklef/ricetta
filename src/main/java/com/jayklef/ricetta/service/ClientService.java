package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClientsList();

    Client saveClient(Client client);

    Client getClientById(Long id) throws ClientNotFoundException;

    Client updateClient(Long id, Client client);

    Client getClientByName(String name) throws ClientNotFoundException;

    void deleteClientById(Long id);
}
