package com.jashwin.apigateway.patient.controller;


import com.jashwin.apigateway.patient.dto.PatientRequest;
import com.jashwin.apigateway.patient.dto.PatientResponse;
import com.jashwin.apigateway.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public PatientResponse savePatientDetails(@RequestBody PatientRequest patientRequest){

        return patientService.savePatientDetails(patientRequest);


    }


    @GetMapping("/getDetailsById/{id}")
    public PatientResponse getPatientDetails(@PathVariable Long id){

        return patientService.getPatientDetailsByID(id);

    }

    @GetMapping("/getPatientIdByDoctorId/{doctorId}")
    public PatientResponse getPatientDetailsByDoctorId(@PathVariable Long doctorId){

        return patientService.getPatientDetailsByDoctorId(doctorId);

    }

    @DeleteMapping("/delete/{id}")
    public void deletePatientDetails(@PathVariable Long id){

        patientService.deletePatientDetails(id);

    }


    @PutMapping("/update/{id}")
    public void updatePatientDetails(@PathVariable  Long id, @RequestBody PatientRequest patientRequest){

        patientService.updatePatientDetails(id,patientRequest);

    }


}
