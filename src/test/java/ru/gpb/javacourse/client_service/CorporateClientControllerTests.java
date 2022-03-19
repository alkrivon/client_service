package ru.gpb.javacourse.client_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.gpb.javacourse.client_service.controller.CorporateClientController;
import ru.gpb.javacourse.client_service.entities.CorporateClient;
import ru.gpb.javacourse.client_service.repository.CorporateClientRepository;
import ru.gpb.javacourse.client_service.service.CorporateClientService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CorporateClientControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CorporateClientRepository corporateClientRepository;

	@MockBean
	CorporateClientService corporateClientService;

	@MockBean
	CorporateClientController corporateClientController;

	@Test
	void getCorporateClientByIdTest() throws Exception {

		when(corporateClientController.getCorporateClientById(anyLong())).thenReturn(
				new CorporateClient(1L, "Test"));

		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/getCorporateClientById/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test"))
				.andExpect(status().isOk());
	}

	@Test
	void getCorporateClientByInnTest() throws Exception {

		when(corporateClientController.getCorporateClientByInn(anyLong())).thenReturn(
				new CorporateClient(1L, "Test"));

		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/getCorporateClientByInn?inn=1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test"))
				.andExpect(status().isOk());
	}

	@Test
	void getAllCorporateClientsTest() throws Exception {

		CorporateClient clientTest1 = new CorporateClient(1L, "Test1");
		CorporateClient clientTest2 = new CorporateClient(2L, "Test2");

		List<CorporateClient> corporateClientListTest = new ArrayList<>();
		corporateClientListTest.add(clientTest1);
		corporateClientListTest.add(clientTest2);

		when(corporateClientController.getAllCorporateClients()).thenReturn(corporateClientListTest);

		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080//getAllCorporateClient"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Test1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Test2"))
				.andExpect(status().isOk());
	}
}
