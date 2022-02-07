package ru.gpb.javacourse.client_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gpb.javacourse.client_service.entities.CorporateClient;

@Repository
public interface CorporateClientRepository extends JpaRepository<CorporateClient, Long> {
    CorporateClient findCorporateClientByInn(Long inn);
}
