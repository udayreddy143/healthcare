package com.jashwin.apigateway.appointment.controller;


import com.SlotBooking.model.AppointmentDTO;
import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import com.jashwin.apigateway.appointment.model.AppointmentRequest;
import com.jashwin.apigateway.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/storeAppointments")
    public void storeAppointments(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.storeAppointments(appointmentRequest);
    }

    @GetMapping("/getAppointments/{doctorId}")
    public List<AppointmentDTO> getppointmentsBySlotId(@PathVariable Integer doctorId) {
       return appointmentService.getAppointmentsBySlotId(doctorId);
    }

    @GetMapping("/getDetailsBySlotId/{slotId}")
    public AppointmentDTO getDetailsBySlotId(@PathVariable Integer slotId) {
        return appointmentService.getDetailsBySlotId(slotId);
    }

    @PutMapping("/update/{slotid}/{status}")
    public void updateAppointment(@PathVariable int slotid, @PathVariable AppointmentStatus status) {
        appointmentService.updateAppointment(slotid, status);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAppointmentVySlotId(@PathVariable int id,String status) {
        appointmentService.deleteAppointmentBySlotId(id);
    }

}
