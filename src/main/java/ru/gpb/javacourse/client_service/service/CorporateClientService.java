package ru.gpb.javacourse.client_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public void addCorporateClient(BigInteger idClient, String name, Long inn) {
        corporateClientRepository.save(new CorporateClient(idClient, name, inn));
    }
}
