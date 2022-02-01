package ru.gpb.javacourse.client_service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpb.javacourse.client_service.dto.PersonClient;

/**
 * @author dzahbarov
 */
@Service
@AllArgsConstructor
public class PersonClientService {

    public PersonClient createPersonClient (String firstaname, String lastname) {
        return new PersonClient(firstaname, lastname);
    }
}
