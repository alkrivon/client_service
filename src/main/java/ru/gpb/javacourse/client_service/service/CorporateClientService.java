package ru.gpb.javacourse.client_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.CorporateClientDto;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.exceptions.NotFoundException;
import ru.gpb.javacourse.client_service.repository.CorporateClientRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class CorporateClientService {

    private final CorporateClientRepository corporateClientRepository;

    @Autowired
    public CorporateClientService(CorporateClientRepository corporateClientRepository) {
        this.corporateClientRepository = corporateClientRepository;
    }

    @Transactional
    public CorporateClient getCorporateClientByInn(Long inn) throws NotFoundException {
       CorporateClient corporateClient = corporateClientRepository.findCorporateClientByInn(inn);
       if (corporateClient != null) {
           return corporateClient;
       }
       throw new NotFoundException("CorporateClient not found with inn = " + inn);
    }

    @Transactional
    public CorporateClient getCorporateClientById(Long id) throws NotFoundException {
        CorporateClient corporateClient = corporateClientRepository.findCorporateClientById(id);
        if (corporateClient != null) {
            return corporateClient;
        }
        throw new NotFoundException("CorporateClient not found with id = " + id);
    }

    @Transactional
    public CorporateClient addCorporateClient(CorporateClientDto corporateClientDto) {
        return corporateClientRepository.save(
                new CorporateClient(corporateClientDto.getInn(), corporateClientDto.getName()));
    }

    @Transactional
    public List<CorporateClient> getAllCorporateClients() {
        return corporateClientRepository.findAll();
    }
}
