package com.SlotBooking.feign;

import com.SlotBooking.model.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "doctorfeign",url = "http://localhost:8084/doctor")
public interface DoctorFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/getDoctordetailsById/{doctorId}")
    DoctorResponse getDoctordetailsByDoctorId(@PathVariable Long doctorId);

}
