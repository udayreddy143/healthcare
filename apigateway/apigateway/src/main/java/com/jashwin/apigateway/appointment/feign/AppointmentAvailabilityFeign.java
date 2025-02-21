package com.jashwin.apigateway.appointment.feign;


import com.jashwin.apigateway.appointment.dto.AppointmentDTO;
import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import com.jashwin.apigateway.appointment.model.AppointmentRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "appointmentfeign",url = "http://localhost:8082/appointment")
public interface AppointmentAvailabilityFeign {


    @RequestMapping(method = RequestMethod.POST, value = "/storeAppointments")
    AppointmentDTO storeAppointments(@RequestBody AppointmentRequest appointmentRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/getDetailsBySlotId/{slotId}")
    AppointmentDTO getDetailsBySlotId(@PathVariable Long slotId);

    @RequestMapping(method = RequestMethod.GET, value = "/getAppointments/{doctorId}")
    AppointmentDTO getppointmentsBySlotId(@PathVariable Long slotId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    AppointmentDTO deleteAppointmentVySlotId(@PathVariable Long slotId);

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{slotid}/{status}")
    AppointmentDTO updateAppointment(@PathVariable int slotid, @PathVariable AppointmentStatus status);

}
