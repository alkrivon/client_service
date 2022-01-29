package ru.gpb.javacourse.client_service.dto;

import lombok.Data;

@Data
public class PersonClient implements Client {

    private String firstname;

    private String lastname;

    public PersonClient(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
