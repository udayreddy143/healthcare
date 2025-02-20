package com.jashwin.apigateway.doctor.feign;

import com.jashwin.apigateway.doctor.model.DoctorRequest;
import com.jashwin.apigateway.doctor.model.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "doctorfeign",url = "http://localhost:8084/doctor")
public interface DoctorFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/storedetails")
    DoctorResponse storeDoctorDetails(@RequestBody DoctorRequest doctorRequest);

}
