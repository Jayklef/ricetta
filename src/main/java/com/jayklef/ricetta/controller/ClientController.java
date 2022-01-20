package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.model.Client;
import com.jayklef.ricetta.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    private final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clients")
    public List<Client> getClientsList(){
        LOGGER.info("Inside get getClientsList of ClientController");
        return clientService.getClientsList();
    }

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        LOGGER.info("Inside get saveClient of ClientController");
        return clientService.saveClient(client);
    }

    @GetMapping("/clients/{id}/")
    public Client getClientById(@PathVariable("id") Long id) throws ClientNotFoundException {
        return clientService.getClientById(id);
    }

    @GetMapping("/clients/{name}")
    public Client getClientByName(@PathVariable("name") String name) throws ClientNotFoundException {
        return clientService.getClientByName(name);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable("id") Long id,
                               @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
        return "Client removed successfully";
    }

}
