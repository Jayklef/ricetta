package com.jayklef.ricetta.utility;

import com.jayklef.ricetta.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ClientUtility {

    @Autowired
    private ClientService clientService;

    public ResponseEntity<Long> calculateTotalClients(Long numberOfClients){
        log.info("Inside calculateTotalClients of ClientUtility");
        Long totalClients = clientService.calculateTotalClients(numberOfClients);
        return new ResponseEntity<>(totalClients, HttpStatus.OK);
    }
}
