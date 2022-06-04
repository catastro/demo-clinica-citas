package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Appointment;
import com.bootcamp.clinica.citas.repositories.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
//@ExtendWith(MockitoExtension.class)
class AppointmentSeviceImplTest {

    @Mock
    AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentSeviceImpl citaSevice;

    @BeforeAll
    static void initAll() {
        log.info("init all");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown");
    }

    @AfterAll
    static void tearDownAll() {
        log.info("tearDownAll");
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    //@Disabled
    @DisplayName("Should save a appointment and then return ok")
    @Test
    void shouldSaveAppointmentAndThenReturnOk() {
        //A: arrange
        var valorEsperado = 2;

        Appointment appointment = new Appointment();
        appointment.setId(2L);

        Mockito.when(appointmentRepository.save(ArgumentMatchers.any()))
                .thenReturn(appointment);

        Mockito.doNothing().when(appointmentRepository.save(ArgumentMatchers.any()));

        //A: act
        Appointment valorReal = citaSevice.save(appointment);

        //A: assert
        assertEquals(valorEsperado, valorReal.getId());
        Mockito.verify(appointmentRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }
}