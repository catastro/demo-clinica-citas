package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DoctorService doctorService;

    @Test
    void findById() throws Exception {

        var valorEsperado = 1;
        Doctor doctorInput = new Doctor();
        doctorInput.setId(1L);

        when(this.doctorService.findById(1L)).thenReturn(doctorInput);

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/doctors/1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Doctor valorReal = this.objectMapper.readValue(content, Doctor.class );

        System.out.println("content = " + content);


        assertEquals(valorEsperado, valorReal.getId());



    }
}