package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Hospital;
import com.example.lab3_20200643.entity.Paciente;
import com.example.lab3_20200643.repository.DoctorRepository;
import com.example.lab3_20200643.repository.HospitalRepository;
import com.example.lab3_20200643.repository.PacienteRepository;
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
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;
    public HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
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
        List<Doctor> listaDoctoresDelHospital = doctorRepository.findByHospital_Id(id);
        model.addAttribute("listaDoctoresxHosptial",listaDoctoresDelHospital);
        return "hospitales/listaDoctores";
    }
    @GetMapping("/pacientes")
    public String listarPaciente(Model model, @RequestParam("id") int id){
        List<Paciente> listaPacientesxHospital = pacienteRepository.findPacienteByHospital_Id(id);
        model.addAttribute("listaPacientesxHospital",listaPacientesxHospital);
        return "hospitales/listaPacientes";
    }


    }


