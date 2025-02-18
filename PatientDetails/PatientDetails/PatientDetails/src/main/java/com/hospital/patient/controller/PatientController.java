package com.hospital.patient.controller;

import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.dto.PatientResponse;
import com.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<Void> savePatientDetails(@RequestBody PatientRequest patientRequest){
        patientService.savePatientDetails(patientRequest);
        System.out.println("new patient details stored");

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/getDetailsById/{id}")
    public PatientResponse getPatientDetails(@PathVariable Long id){
        System.out.println("fetched patient details by id:"+id );
        return patientService.getPatientDetailsByID(id);

    }

    @GetMapping("/getPatientIdByDoctorId/{doctorId}")
    public Long getPatientDetailsByDoctorId(@PathVariable Long doctorId){
        return patientService.getPatientDetailsByDoctorId(doctorId);

    }

    @DeleteMapping("/delete/{id}")
    public void deletePatientDetails(@PathVariable Long id){
        patientService.deletePatientDetails(id);
        System.out.println("deleted patient details with id:" +id);
    }


    @PutMapping("/update/{id}")
    public void updatePatientDetails(@PathVariable  Long id, @RequestBody PatientRequest patientRequest){
        patientService.updatePatientDetails(id,patientRequest);

    }


}
