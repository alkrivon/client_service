package ru.gpb.javacourse.client_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.RetailClientDto;
import ru.gpb.javacourse.client_service.entities.RetailClient;
import ru.gpb.javacourse.client_service.repository.RetailClientRepository;

import java.time.LocalDate;

/**
 * @author dzahbarov
 */
@Service
public class RetailClientService {

    private final RetailClientRepository clientRepository;

    @Autowired
    public RetailClientService(RetailClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public RetailClient addRetailClient(RetailClientDto retailClient) {
        return clientRepository.save(new RetailClient(retailClient.getInn(),
                retailClient.getFirstname(),
                retailClient.getLastname(),
                retailClient.getPassport(),
                retailClient.getBirthday()));
    }

    public RetailClient getRetailClientByNameAndBirthDateAndPassport(String firstname, String lastname, Long passport, LocalDate dateOfBirth) {
        return clientRepository.findByFirstnameAndLastnameAndBirthdayAndPassport(firstname, lastname, dateOfBirth, passport);
    }
}
