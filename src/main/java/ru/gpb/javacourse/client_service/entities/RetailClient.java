package ru.gpb.javacourse.client_service.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "retail_clients")
@Getter
@Setter
public class RetailClient extends Client {

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "passport")
    private Long passport;

    @Column(name = "birthday")
    private LocalDate birthday;

    public RetailClient(Long inn, String firstname, String lastname, Long passport, LocalDate birthday) {
        super(inn);
        this.firstname = firstname;
        this.lastname = lastname;
        this.passport = passport;
        this.birthday = birthday;
    }
}