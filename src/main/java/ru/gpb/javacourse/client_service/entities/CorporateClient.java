package ru.gpb.javacourse.client_service.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "corporate_clients")
@NoArgsConstructor
@Getter
@Setter
public class CorporateClient extends Client {

    @Column
    private String name;

    public CorporateClient(Long inn, String name) {
        super(inn);
        this.name = name;
    }
}
