package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Hospital;
import com.example.lab3_20200643.entity.Paciente;
import com.example.lab3_20200643.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospitales")
public class HospitalController {
    //###############################################3
    final HospitalRepository hospitalRepository;


    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    //####################################################

    @GetMapping("/listar")
    public String listar(Model model){
        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", lista);
        return "hospitales/lista";
    }
    @GetMapping("/doctores")
    public String listarDoctores(Model model, @RequestParam("id")  int id){
        List<Doctor> listaDoctoresxHosptial = hospitalRepository.listaDoctoresHospital(id);
        model.addAttribute("listaDoctoresxHosptial",listaDoctoresxHosptial);
        return "doctores/lista";

    }



    }


