package ru.gpb.javacourse.client_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.entities.RetailClient;

import java.time.LocalDate;
import java.util.List;

/**
 * @author dzahbarov
 */
@Repository
public interface RetailClientRepository extends JpaRepository<RetailClient, Long> {
    RetailClient findByFirstnameAndLastnameAndBirthdayAndPassport(String firstName, String lastName, LocalDate birthday, Long passport);
    RetailClient findRetailClientById(Long id);
    List<RetailClient> findAll();
}
