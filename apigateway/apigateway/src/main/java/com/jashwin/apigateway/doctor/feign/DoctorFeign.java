package com.jashwin.apigateway.doctor.feign;

import com.jashwin.apigateway.doctor.model.DoctorRequest;
import com.jashwin.apigateway.doctor.model.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@FeignClient(value = "doctorfeign",url = "http://localhost:8084/doctor")
public interface DoctorFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/storedetails")
    DoctorResponse storeDoctorDetails(@RequestBody DoctorRequest doctorRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/storeRelatedDisease/{specilization}")
    DoctorResponse storeRelatedDisease(@PathVariable("specilization") String specilization, @RequestParam("diseases") Set<String> diseases);

    @RequestMapping(method = RequestMethod.GET, value = "/fetchRelatedDisease")
    Map<String, List<String>> fetchRelatedDisease();

    @RequestMapping(method = RequestMethod.GET, value = "/getDoctordetails")
    List<DoctorResponse> getDoctorDetails();

    @RequestMapping(method = RequestMethod.GET, value = "/getDoctordetailsById/{doctorId}")
    DoctorResponse getDoctorDetailsById();



}
