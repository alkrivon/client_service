package ru.gpb.javacourse.client_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dzahbarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Client {

    @Id
    @GeneratedValue
    private long id = 0;

    @Transient
    List<Account> accounts = new LinkedList<>();

    @Column(name = "idClient")
    BigInteger idClient = null;

    public Client(BigInteger idClient) {
        this.idClient = idClient;
    }
}
