package ru.gpb.javacourse.client_service.dto;

import lombok.Data;

@Data
public class CorporateClientDto extends Client {

    String name;
    Long inn;
}
