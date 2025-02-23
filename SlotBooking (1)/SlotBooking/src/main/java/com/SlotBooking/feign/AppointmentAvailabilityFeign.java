package com.SlotBooking.feign;

import com.SlotBooking.model.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(value = "appointmentfeign",url = "http://localhost:8082/appointment")
public interface AppointmentAvailabilityFeign {

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{slotId}/{status}")
    void updateStatusInAppointmentService(@PathVariable Long slotId, @PathVariable("status") String status);


    @RequestMapping(method = RequestMethod.GET, value = "/getDetailsBySlotId/{slotId}")
    AppointmentDTO getDetailsBySlotId(@PathVariable int slotId);

    @RequestMapping(method = RequestMethod.GET, value = "/getAppointmentsByDoctorId/{doctorId}")
    AppointmentDTO getAppointmentsByDoctorId(@PathVariable int doctorId);

}
