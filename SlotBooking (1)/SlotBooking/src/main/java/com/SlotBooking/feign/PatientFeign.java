package com.SlotBooking.feign;

import com.SlotBooking.model.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "patientFeign",url = "http://localhost:8081/patient")
public interface PatientFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/getPatientIdByDoctorId/{doctorId}")
    Integer getPatientIdByUsingDoctorId(@PathVariable("doctorId") Long doctorId);

    @RequestMapping(method = RequestMethod.GET, value = "/getDetailsById/{patientId}")
    PatientResponse getPatientDetailsById(@PathVariable("patientId") Long patientId);

}
