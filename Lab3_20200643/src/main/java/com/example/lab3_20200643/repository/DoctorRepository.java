package com.example.lab3_20200643.repository;

import com.example.lab3_20200643.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByHospital_Id(int id);

}
