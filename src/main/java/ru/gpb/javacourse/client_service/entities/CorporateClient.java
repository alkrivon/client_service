package ru.gpb.javacourse.client_service.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gpb.javacourse.client_service.dto.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "CorporateClients")
@Data
@NoArgsConstructor
public class CorporateClient extends Client {

    @Column
    private String name;
    @Column
    private Long inn;

    public CorporateClient(BigInteger idClient, String name, Long inn) {
        super(idClient);
        this.name = name;
        this.inn = inn;
    }
}
