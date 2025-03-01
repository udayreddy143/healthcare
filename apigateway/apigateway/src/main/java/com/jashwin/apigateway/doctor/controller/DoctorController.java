package com.jashwin.apigateway.doctor.controller;

import com.jashwin.apigateway.doctor.model.DoctorRequest;
import com.jashwin.apigateway.doctor.model.DoctorResponse;
import com.jashwin.apigateway.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

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
    public DoctorResponse storeDoctorDetails(@RequestBody DoctorRequest doctorRequest) {

        return doctorService.storeDoctorDetails(doctorRequest);

    }

    @PostMapping("/storeRelatedDisease/{specilization}")
    public DoctorResponse storeRelatedDisease(@PathVariable("specilization") String specilization, @RequestParam("diseases")Set<String> diseases) {

        return doctorService.storeRelatedDisease(specilization,diseases);

    }

    @GetMapping("/fetchRelatedDisease")
    public Map<String, List<String>> fetchRelatedDisease() {

        return doctorService.getRelatedDisease();

    }

    @GetMapping("/getDoctordetails")
    public List<DoctorResponse> getDoctorDetails() {

        return doctorService.getDoctorDetails();

    }

    @GetMapping("/getDoctordetailsById/{doctorId}")
    public DoctorResponse getDoctorDetailsById(@PathVariable Integer doctorId) {

        return doctorService.getDoctorDetailsById(doctorId);

    }
}
