package com.example.lab3_20200643.repository;

import com.example.lab3_20200643.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    List<Paciente> findPacienteByHospital_Id (int id);
    List<Paciente> findPacienteByDoctor_Id( int id);
    @Transactional
    @Modifying
    @Query(value = "update paciente set numero_habitacion=?1 where id=?2", nativeQuery = true)
    void actualizarPaciente(int num, int id);


    @Transactional
    @Modifying
    @Query(value = "update paciente set doctor_id=?1 where id=?2", nativeQuery = true)
    void actualizarDoctorPaciente(int num, int id);


}
