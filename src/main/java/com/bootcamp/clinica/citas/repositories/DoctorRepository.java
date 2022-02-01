package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {

    @Query("SELECT p FROM Doctor p WHERE UPPER(nombre) LIKE CONCAT('%',UPPER(:#{#nombre}),'%')  ")
    List<Doctor> find(String nombre);

//    @Query("SELECT p FROM Product p " +
//            "WHERE UPPER(p.name) LIKE CONCAT('%',UPPER(:#{#param.name}),'%') " +
//            "AND p.color=:#{#param.color} " +
//            "AND p.size=:#{#param.size} " +
//            "AND p.weight<:#{#param.weight}")
//    List<Product> findByParams(@Param("param") FindProductRequest param);

}
