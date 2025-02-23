package com.jaswin.appointmentavailability.service;

import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import com.jaswin.appointmentavailability.model.AppointmentRequest;


public interface AppointmentService {
    void testService();

    void storeAppointments(AppointmentRequest appointmentRequest);

    AppointmentDTO getAppointmentsByDoctorId(int doctorId);

    AppointmentDTO getDetailsBySlotId(int slotId);

    void updateAppointment(Integer id, AppointmentStatus status);

    void deleteAppointmentBySlotId(int id);
}
