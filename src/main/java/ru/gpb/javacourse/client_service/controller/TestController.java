package ru.gpb.javacourse.client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gpb.javacourse.client_service.dto.PersonClient;
import ru.gpb.javacourse.client_service.service.PersonClientService;

/**
 * @author dzahbarov
 */

@RestController
public class TestController {

    public PersonClientService personClientService;

    @Autowired
    public TestController(PersonClientService personClientService) {
        this.personClientService = personClientService;
    }

    @PostMapping("/createNewPerson")
    public ResponseEntity createPerson(@RequestParam String firstname, @RequestParam String lastname) {
        PersonClient personClient = personClientService.createPersonClient(firstname, lastname);
        return new ResponseEntity<>("firstname " + personClient.getFirstname() + " lastname " +
                personClient.getLastname(), HttpStatus.OK);
    }
}
