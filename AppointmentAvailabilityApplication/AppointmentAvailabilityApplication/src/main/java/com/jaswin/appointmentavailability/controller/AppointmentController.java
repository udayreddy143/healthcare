package com.jaswin.appointmentavailability.controller;

import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import com.jaswin.appointmentavailability.model.AppointmentRequest;
import com.jaswin.appointmentavailability.model.UpdateAppointmentRequest;
import com.jaswin.appointmentavailability.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    //take list of Ids
    // make all ids status to Inactive /Active

    @DeleteMapping("/delete/{id}")
    public void deleteAppointmentVySlotId(@PathVariable int id,String status) {
        appointmentService.deleteAppointmentBySlotId(id);
    }

}
