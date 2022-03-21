package ru.gpb.javacourse.client_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.gpb.javacourse.client_service.controller.RetailClientController;
import ru.gpb.javacourse.client_service.entities.RetailClient;
import ru.gpb.javacourse.client_service.repository.RetailClientRepository;
import ru.gpb.javacourse.client_service.service.RetailClientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RetailClientControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RetailClientRepository retailClientRepository;

    @MockBean
    RetailClientService retailClientService;

    @MockBean
    RetailClientController retailClientController;

    @Test
    void getRetailClientByIdTest() throws Exception {

        when(retailClientController.getRetailClientById(anyLong())).thenReturn(
                new RetailClient(1L, "testFirstname",
                                            "testLastname",
                                            1234L,
                                            LocalDate.of(2002,10,10)));

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/getRetailClientById/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("testFirstname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("testLastname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.passport").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthday").value("2002-10-10"))
                .andExpect(status().isOk());
    }

    @Test
    void getRetailClientByNameAndBirthDateAndPassportTest() throws Exception {

        when(retailClientController.getRetailClientByNameAndBirthDateAndPassport(anyString(),
                                                                                anyString(),
                                                                                any(),
                                                                                anyLong())).thenReturn(
                new RetailClient(1L, "testFirstname",
                        "testLastname",
                        1234L,
                        LocalDate.of(2002,10,10)));

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/getRetailClientByNameAndBirthDateAndPassport" +
                                                        "?firstname=testFirstname" +
                                                        "&lastname=testLastname" +
                                                        "&dateOfBirth=2002-10-10" +
                                                        "&passport=1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("testFirstname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("testLastname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.passport").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthday").value("2002-10-10"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllRetailClientsTest() throws Exception {

        RetailClient clientTest1 = new RetailClient(1L, "testFirstname1",
                "testLastname1",
                1234L,
                LocalDate.of(2002,10,10));

        RetailClient clientTest2 = new RetailClient(1L, "testFirstname2",
                "testLastname2",
                4321L,
                LocalDate.of(2003,11,11));

        List<RetailClient> retailClientListTest = new ArrayList<>();
        retailClientListTest.add(clientTest1);
        retailClientListTest.add(clientTest2);

        when(retailClientController.getAllRetailClients()).thenReturn(retailClientListTest);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080//getAllRetailClient"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstname").value("testFirstname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastname").value("testLastname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].passport").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthday").value("2002-10-10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstname").value("testFirstname2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastname").value("testLastname2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].passport").value("4321"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].birthday").value("2003-11-11"))
                .andExpect(status().isOk());
    }
}
