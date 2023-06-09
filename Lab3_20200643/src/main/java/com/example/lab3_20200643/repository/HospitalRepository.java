package com.example.lab3_20200643.repository;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {


}
