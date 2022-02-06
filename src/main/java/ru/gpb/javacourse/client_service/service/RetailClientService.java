package ru.gpb.javacourse.client_service.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.RetailClient;
import ru.gpb.javacourse.client_service.repository.ClientRepository;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author dzahbarov
 */
@Service
@NoArgsConstructor
public class RetailClientService {

    private ClientRepository clientRepository;

    @Autowired
    public RetailClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addRetailClient(BigInteger idClient, String firstname, String lastname, Long passport, LocalDate dateOfBirth) {
         clientRepository.addRetailClient(new RetailClient(idClient, firstname, lastname, passport, dateOfBirth));
    }

    public RetailClient getRetailClientByNameAndBirthDateAndPassport(String firstname, String lastname, Long passport, LocalDate dateOfBirth) {
       return clientRepository.getRetailClientByNameAndBirthDateAndPassport(firstname, lastname, passport, dateOfBirth);
    }
}
