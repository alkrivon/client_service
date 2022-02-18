package ru.gpb.javacourse.client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.gpb.javacourse.client_service.dto.CorporateClientDto;
import ru.gpb.javacourse.client_service.dto.RetailClientDto;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.entities.RetailClient;
import ru.gpb.javacourse.client_service.exceptions.NotFoundException;
import ru.gpb.javacourse.client_service.service.CorporateClientService;
import ru.gpb.javacourse.client_service.service.RetailClientService;
import java.time.LocalDate;
import java.util.List;

/**
 * @author dzahbarov
 */

@RestController
public class RetailClientController {

    private final RetailClientService retailClientService;

    @Autowired
    public RetailClientController(RetailClientService retailClientService, CorporateClientService corporateClientService) {
        this.retailClientService = retailClientService;
    }

    @PostMapping("/addRetailClient")
    public RetailClient addRetailClient(@RequestBody RetailClientDto retailClient) {
        return retailClientService.addRetailClient(retailClient);
    }

    @GetMapping("/getRetailClientByNameAndBirthDateAndPassport")
    public RetailClient getRetailClientByNameAndBirthDateAndPassport(@RequestParam String firstname,
                                                                        @RequestParam String lastname,
                                                                        @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                                                                        @RequestParam Long passport) throws NotFoundException {
        return retailClientService.getRetailClientByNameAndBirthDateAndPassport(firstname, lastname, passport, dateOfBirth);
    }

    @GetMapping("/getRetailClientById/{id}")
    public RetailClient getRetailClientById(@PathVariable Long id) throws NotFoundException {
        return retailClientService.getRetailClientById(id);
    }

    @GetMapping("/getAllRetailClient")
    public List<RetailClient> getAllRetailClients() {
        return retailClientService.getAllRetailClients();
    }
}
