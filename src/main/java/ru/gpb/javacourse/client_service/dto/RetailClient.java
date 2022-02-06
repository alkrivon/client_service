package ru.gpb.javacourse.client_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "RetailClients")
public class RetailClient extends Client {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "passport")
    private Long passport;

    @Column(name = "dataOfBirth")
    private LocalDate dataOfBirth;

    public RetailClient(BigInteger idClient, String firstname, String lastname, Long passport, LocalDate dataOfBirth) {
        super(idClient);
        this.firstname = firstname;
        this.lastname = lastname;
        this.passport = passport;
        this.dataOfBirth = dataOfBirth;
    }
}
