package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Appointment;
import com.bootcamp.clinica.citas.services.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CitasApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AppointmentService appointmentService;


	@Test
	void findById() throws Exception {
		//A: arrange
		var valorEsperado = 2;
		Appointment cita = new Appointment();
		cita.setId(2L);

		Mockito.when(appointmentService.findById(ArgumentMatchers.any()))
				.thenReturn(cita);

		//A: act
		MvcResult result = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/appointments/2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		Appointment valorReal = this.objectMapper.readValue(content, Appointment.class);

		//A: assert
		Assertions.assertEquals(valorEsperado, valorReal.getId());
	}

}
