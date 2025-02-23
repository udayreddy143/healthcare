package com.example.Doctor.controller;

import com.example.Doctor.enums.Specialization;

import com.example.Doctor.model.DoctorRequest;
import com.example.Doctor.model.DoctorResponse;
import com.example.Doctor.service.DoctorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/storedetails")
    public DoctorResponse storedoctordetails(@RequestBody DoctorRequest doctorRequest) {

        return doctorService.storedoctordetails(doctorRequest);

    }

    @PostMapping("/storeRelatedDisease/{specialization}")
    public DoctorResponse storeRelatedDisease(
            @PathVariable("specialization") String specialization,
            @RequestBody Set<String> diseases) {  // Accept JSON body
        return doctorService.storeRelatedDisease(specialization, diseases);
    }

    @GetMapping("/fetchRelatedDisease")
    public Map<String, List<String>> fetchRelatedDisease() {

        return doctorService.getRelatedDisease();

    }

    @GetMapping("/getDoctordetails")
    public List<DoctorResponse> getDoctordetails() {

        return doctorService.getDoctordetails();

    }

    @GetMapping("/getDoctordetailsById/{doctorId}")
    public DoctorResponse getDoctordetailsByDoctorId(@PathVariable int doctorId) {

        return doctorService.getDoctordetailsByDoctorId(doctorId);

    }
}
