package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();

    Client saveClient(Client client);

    Client findClientById(Long id) throws ClientNotFoundException;

    Client updateClient(Long id, Client client);

    Client findClientByName(String name) throws ClientNotFoundException;

    void deleteClientById(Long id);

    Long calculateTotalClients(Long numberOfClients);
}
