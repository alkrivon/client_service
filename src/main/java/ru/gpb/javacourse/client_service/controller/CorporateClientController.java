package ru.gpb.javacourse.client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gpb.javacourse.client_service.dto.CorporateClientDto;
import ru.gpb.javacourse.client_service.dto.RetailClientDto;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.entities.RetailClient;
import ru.gpb.javacourse.client_service.service.CorporateClientService;
import ru.gpb.javacourse.client_service.service.RetailClientService;

import java.time.LocalDate;

/**
 * @author dzahbarov
 */
public class CorporateClientController {
    private final CorporateClientService corporateClientService;

    public CorporateClientController(CorporateClientService corporateClientService) {
        this.corporateClientService = corporateClientService;
    }

    @PostMapping("/addCorporateClient")
    public CorporateClient addCorporateClient(@RequestBody CorporateClientDto corporateClient) {
        return corporateClientService.addCorporateClient(corporateClient);
    }

    @GetMapping("/getCorporateClientByInn")
    public CorporateClient getCorporateClientByInn(@RequestParam Long inn) {
        return corporateClientService.getCorporateClientByInn(inn);
    }
}
