package ru.gpb.javacourse.client_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gpb.javacourse.client_service.dto.PersonClient;

/**
 * @author dzahbarov
 */

@RestController
public class TestController {

    @RequestMapping(path = "/createNewPerson", method = RequestMethod.POST)
    public String createPerson(@RequestParam String firstname, @RequestParam String lastname) {
        PersonClient personClient = new PersonClient(firstname, lastname);
        System.out.println("firstname " + personClient.getFirstname() + " lastname " + personClient.getLastname());
        return "ok";
    }

}
