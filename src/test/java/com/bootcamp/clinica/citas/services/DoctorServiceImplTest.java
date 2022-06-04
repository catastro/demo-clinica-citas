package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.AbstractTest;
import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.exception.NotFoundException;
import com.bootcamp.clinica.citas.repositories.DoctorRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceImplTest extends AbstractTest {

    private DoctorRepository doctorRepository;
    private DoctorService doctorService;

    @BeforeEach
    public void init() {
        doctorRepository = Mockito.mock(DoctorRepository.class);
        doctorService = new DoctorServiceImpl(doctorRepository);
    }

    @Nested
    @DisplayName("Prueba anidada")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)//evitará que se cree una nueva instancia de su clase para cada prueba en la clase
    class CreateDoctorTest {
        private Doctor doctor;

        @BeforeAll
        void init() throws IOException, URISyntaxException {
            doctor = convertTo("/request-docto1.json", Doctor.class);
        }

        @DisplayName("should Update Specialty And Then Return Ok")
        @Test
        void shouldUpdateSpecialtyAndThenReturnOk() {
            //A: Arrange
            int edadEsperada = 25;
            Mockito.when(doctorRepository.findById(any()))
                    .thenReturn(Optional.of(doctor));
            Mockito.when(doctorRepository.save(any()))
                    .thenReturn(doctor);

            //A: Act
            Doctor doctor = doctorService.updateEspecialidad(1L, "Pediatría");

            //A: Assert
            assertNotNull(doctor);
            assertEquals(edadEsperada, doctor.getEdad());
        }

        @DisplayName("should Update Specialty And Then Return Not found")
        @Test
        void shouldUpdateSpecialtyAndThenReturnNotFound() {
            //A: Arrange
            Mockito.when(doctorRepository.findById(any()))
                    .thenReturn(Optional.empty());

            //A: Act
            NotFoundException exception = assertThrows(NotFoundException.class, () -> {
                doctorService.updateEspecialidad(1L, "Pediatría");
            });
            //A: Assert
            assertEquals("Doctor no existe", exception.getMessage());
        }

        @Test
        @DisplayName("should save doctor successfully and then return ok")
        void shouldSaveDoctorSuccessfullyAndThenOk() {
            //A: arrange
            Mockito.when(doctorRepository.save(any()))
                    .thenReturn(doctor);
            //A: act
            Doctor response = doctorService.save(doctor);
            //A: assert
            assertEquals(25, response.getEdad());

        }
    }
}