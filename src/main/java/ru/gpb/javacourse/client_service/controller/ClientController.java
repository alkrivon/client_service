package ru.gpb.javacourse.client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gpb.javacourse.client_service.dto.RetailClient;
import ru.gpb.javacourse.client_service.service.RetailClientService;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author dzahbarov
 */

@RestController
public class ClientController {

    public RetailClientService retailClientService;

    @Autowired
    public ClientController(RetailClientService retailClientService) {
        this.retailClientService = retailClientService;
    }

    @PostMapping("/AddRetailClient")
    public ResponseEntity addRetailClient(@RequestParam String firstname, @RequestParam String lastname,
                                          @RequestParam Long passport, @RequestParam LocalDate dateOfBirth,
                                          @RequestParam BigInteger idClient) {

        retailClientService.addRetailClient(idClient, firstname, lastname, passport, dateOfBirth);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/GetRetailClientByNameAndBirthDateAndPassport")
    public ResponseEntity<RetailClient> getRetailClientByNameAndBirthDateAndPassport(@RequestParam String firstname, @RequestParam String lastname,
                                                                       @RequestParam Long passport, @RequestParam LocalDate dateOfBirth) {
        return new ResponseEntity<>(retailClientService.getRetailClientByNameAndBirthDateAndPassport(firstname, lastname, passport, dateOfBirth),HttpStatus.OK);
    }
}
