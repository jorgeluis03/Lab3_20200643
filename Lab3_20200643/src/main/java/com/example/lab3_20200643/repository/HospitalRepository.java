package com.example.lab3_20200643.repository;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM doctor where hospital_id= ?1 ")
    List<Doctor> listaDoctoresHospital (int hospital_id);

    @Query(nativeQuery = true, value = "SELECT * FROM paciente where hospital_id= ?1 ")
    List<Doctor> listaPacientesxHospital (int hospital_id);

}
