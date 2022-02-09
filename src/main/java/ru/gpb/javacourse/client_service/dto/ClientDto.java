package ru.gpb.javacourse.client_service.dto;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dzahbarov
 */

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public abstract class ClientDto {
    private long id;
    private List<Account> accounts = new LinkedList<>();
    private Long inn;

    public ClientDto(Long inn) {
        this.inn = inn;
    }
}
