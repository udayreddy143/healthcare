package com.jashwin.apigateway.appointment.service;



import com.SlotBooking.model.AppointmentDTO;
import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import com.jashwin.apigateway.appointment.model.AppointmentRequest;

import java.util.List;


public interface AppointmentService {


    void storeAppointments(AppointmentRequest appointmentRequest);

    List<AppointmentDTO> getAppointmentsBySlotId(int id);

    AppointmentDTO getDetailsBySlotId(int slotId);

    void updateAppointment(Integer id, AppointmentStatus status);

    void deleteAppointmentBySlotId(int id);
}
