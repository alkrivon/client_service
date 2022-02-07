package ru.gpb.javacourse.client_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class RetailClientDto extends Client {
    private String firstname;
    private String lastname;
    private Long passport;
    private LocalDate birthday;

    public RetailClientDto(Long inn, String firstname, String lastname, Long passport, LocalDate birthday) {
        super(inn);
        this.firstname = firstname;
        this.lastname = lastname;
        this.passport = passport;
        this.birthday = birthday;
    }
}
