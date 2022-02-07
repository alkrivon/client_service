package ru.gpb.javacourse.client_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gpb.javacourse.client_service.entities.RetailClient;

import java.time.LocalDate;

/**
 * @author dzahbarov
 */
public interface RetailClientRepository extends JpaRepository<RetailClient, Long> {
    RetailClient findByFirstnameAndLastnameAndBirthdayAndPassport(String firstName, String lastName, LocalDate birthday, Long passport);
}
