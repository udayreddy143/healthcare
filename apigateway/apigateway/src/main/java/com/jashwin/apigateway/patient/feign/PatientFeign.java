package com.jashwin.apigateway.patient.feign;


import com.jashwin.apigateway.patient.dto.PatientRequest;
import com.jashwin.apigateway.patient.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "patientFeign",url = "http://localhost:8081/patient")
public interface PatientFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    PatientResponse savePatientDetails(@RequestBody PatientRequest patientRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/getDetailsById/{id}")
    PatientResponse getPatientDetails(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/getPatientIdByDoctorId/{doctorId}")
    PatientResponse getPatientDetailsByDoctorId(@PathVariable Long doctorId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    PatientResponse deletePatientDetails(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    PatientResponse updatePatientDetails(@PathVariable  Long id, @RequestBody PatientRequest patientRequest);




}
