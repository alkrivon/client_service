package ru.gpb.javacourse.client_service.repository;

import org.springframework.stereotype.Repository;
import ru.gpb.javacourse.client_service.dto.RetailClient;
import ru.gpb.javacourse.client_service.service.RetailClientService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;

/**
 * @author dzahbarov
 */
@Repository
public class ClientRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addRetailClient(RetailClient retailClient) {
        entityManager.persist(retailClient);
        entityManager.flush();
    }

    @Transactional
    public RetailClient getRetailClientByNameAndBirthDateAndPassport (String firstname, String lastname, Long passport, LocalDate dateOfBirth) {
        String hql = "FROM User where firstname = :firstname and lastname = :lastname and passport = :passport and dateOfBirth = :dateOfBirth";
        TypedQuery<RetailClient> query = entityManager.createQuery(hql, RetailClient.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        query.setParameter("passport", passport);
        query.setParameter("dateOfBirth", dateOfBirth);
        RetailClient retailClient;
        retailClient = query.getSingleResult();
        return retailClient;
    }
}
