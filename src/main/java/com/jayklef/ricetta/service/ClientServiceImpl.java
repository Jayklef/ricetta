package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.model.Client;
import com.jayklef.ricetta.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClients() {
        log.info("Inside findAllClients of ClientServiceImpl Class ");
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        log.info("Inside saveClient of ClientServiceImpl Class ");
        return clientRepository.save(client);
    }

    @Override
    public Client findClientById(Long id) throws ClientNotFoundException {
        log.info("Inside findClientById of ClientServiceImpl Class ");
        Optional<Client> client = clientRepository.findById(id);

        if (id == null){
            throw new ClientNotFoundException("Client not found");
        }
        return clientRepository.findById(id).get();
    }

    @Override
    public Client findClientByName(String name) throws ClientNotFoundException {
        log.info("Inside findClientByName of ClientServiceImpl Class ");
        Client client = clientRepository.findClientByName(name);

        if (name == null || name.isEmpty() || name.isBlank()){
            throw new ClientNotFoundException("Name not found");
        }
        return clientRepository.findClientByName(name);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        log.info("Inside updateClient of ClientServiceImpl Class ");
        Client clientInDb = clientRepository.findById(id).get();

        if (Objects.nonNull(client.getName())&&
        !"".equalsIgnoreCase(client.getName())){
            client.setName(client.getName());
        }

        if (Objects.nonNull(client.getEmail())&&
                !"".equalsIgnoreCase(client.getEmail())){
            client.setEmail(client.getEmail());
        }

        if (Objects.nonNull(client.getBirthdate())&&
                !"".equalsIgnoreCase(client.getBirthdate().toString())){
            client.setBirthdate(client.getBirthdate());
        }

        if (Objects.nonNull(client.getAddress())&&
                !"".equalsIgnoreCase(client.getAddress())){
            client.setAddress(client.getAddress());
        }

        if (Objects.nonNull(client.getPhonenumber())&&
                !"".equalsIgnoreCase(client.getPhonenumber())){
            client.setPhonenumber(client.getPhonenumber());
        }
        return clientRepository.save(clientInDb);
    }

    @Override
    public void deleteClientById(Long id) {
        log.info("Inside deleteClientById of ClientServiceImpl Class ");
        clientRepository.deleteById(id);
    }

    @Override
    public Long calculateTotalClients(Long numberOfClients) {
        List<Client> clients = clientRepository.findAll();
        
        return clients.stream()
                .count();
    }
}
