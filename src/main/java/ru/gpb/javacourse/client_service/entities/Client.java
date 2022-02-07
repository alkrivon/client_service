package ru.gpb.javacourse.client_service.entities;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dzahbarov
 */

@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public abstract class Client {

    @Id
    @GeneratedValue
    private long id;

    @Transient
    private List<Account> accounts = new LinkedList<>();

    @Column(name = "inn")
    private Long inn;

    public Client(Long inn) {
        this.inn = inn;
    }
}
