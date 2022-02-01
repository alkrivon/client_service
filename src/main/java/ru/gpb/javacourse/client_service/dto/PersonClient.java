package ru.gpb.javacourse.client_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonClient implements Client {

    private String firstname;

    private String lastname;

}
