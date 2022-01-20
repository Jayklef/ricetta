package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.model.Client;
import com.jayklef.ricetta.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    private final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClientsList(){
        LOGGER.info("Inside get getClientsList of ClientController");
        List<Client> clientList = clientService.findAllClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        LOGGER.info("Inside get saveClient of ClientController");
        Client neClient = clientService.saveClient(client);
        return new ResponseEntity<>(neClient, HttpStatus.CREATED);
    }

    @GetMapping("/clients/{id}/")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) throws ClientNotFoundException {
       Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clients/{name}")
    public ResponseEntity<Client> getClientByName(@PathVariable("name") String name) throws ClientNotFoundException {
       Client client = clientService.findClientByName(name);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,
                               @RequestBody Client client){
        Client updateClient = clientService.updateClient(id, client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
        return "Client removed successfully";
    }

}
