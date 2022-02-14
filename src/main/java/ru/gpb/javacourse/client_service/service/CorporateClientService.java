package ru.gpb.javacourse.client_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.CorporateClientDto;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.repository.CorporateClientRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
public class CorporateClientService {

    private final CorporateClientRepository corporateClientRepository;

    @Autowired
    public CorporateClientService(CorporateClientRepository corporateClientRepository) {
        this.corporateClientRepository = corporateClientRepository;
    }

    @Transactional
    public CorporateClient getCorporateClientByInn(Long inn) {
        return corporateClientRepository.findCorporateClientByInn(inn);
    }
    @Transactional
    public CorporateClient getCorporateClientById(Long id) {
        return corporateClientRepository.findCorporateClientById(id);
    }

    @Transactional
    public CorporateClient addCorporateClient(CorporateClientDto corporateClientDto) {
        return corporateClientRepository.save(
                new CorporateClient(corporateClientDto.getInn(), corporateClientDto.getName()));
    }
}
