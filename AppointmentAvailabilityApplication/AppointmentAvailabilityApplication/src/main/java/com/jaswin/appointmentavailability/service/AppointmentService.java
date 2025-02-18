package com.jaswin.appointmentavailability.service;

import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import com.jaswin.appointmentavailability.model.AppointmentRequest;

import java.util.List;


public interface AppointmentService {
    void testService();

    void storeAppointments(AppointmentRequest appointmentRequest);

    List<AppointmentDTO> getAppointmentsBySlotId(int id);

    AppointmentDTO getDetailsBySlotId(int slotId);

    void updateAppointment(Integer id, AppointmentStatus status);

    void deleteAppointmentBySlotId(int id);
}
