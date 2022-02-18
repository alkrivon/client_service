package ru.gpb.javacourse.client_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.RetailClientDto;
import ru.gpb.javacourse.client_service.entities.RetailClient;
import ru.gpb.javacourse.client_service.exceptions.NotFoundException;
import ru.gpb.javacourse.client_service.repository.RetailClientRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

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

    @Transactional
    public RetailClient addRetailClient(RetailClientDto retailClient) {
        return clientRepository.save(new RetailClient(retailClient.getInn(),
                retailClient.getFirstname(),
                retailClient.getLastname(),
                retailClient.getPassport(),
                retailClient.getBirthday()));
    }

    @Transactional
    public RetailClient getRetailClientByNameAndBirthDateAndPassport(String firstname, String lastname,
                                                                     Long passport, LocalDate dateOfBirth) throws NotFoundException {
        RetailClient retailClient = clientRepository.findByFirstnameAndLastnameAndBirthdayAndPassport(firstname, lastname,
                                                                                                    dateOfBirth, passport);
        if (retailClient != null) {
            return retailClient;
        }
        throw new NotFoundException("RetailClient not found");
    }

    @Transactional
    public RetailClient getRetailClientById(Long id) throws NotFoundException {
        RetailClient retailClient = clientRepository.findRetailClientById(id);
        if (retailClient != null) {
            return retailClient;
        }
         throw new NotFoundException("RetailClient not found with id = " + id);
    }

    @Transactional
    public List<RetailClient> getAllRetailClients() {
        return clientRepository.findAll();
    }
}
