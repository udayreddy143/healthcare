package com.jashwin.apigateway.appointment.service.impl;


import com.jashwin.apigateway.appointment.dto.AppointmentDTO;
import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import com.jashwin.apigateway.appointment.feign.AppointmentAvailabilityFeign;
import com.jashwin.apigateway.appointment.model.AppointmentRequest;
import com.jashwin.apigateway.appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentAvailabilityFeign appointmentFeign;


    @Override
    public void storeAppointments(AppointmentRequest appointmentRequest) {
        appointmentFeign.storeAppointments(appointmentRequest);

    }

    @Override
    public List<AppointmentDTO> getAppointmentsBySlotId(int doctorId) {
        return Collections.singletonList(appointmentFeign.getppointmentsBySlotId((long) doctorId));

    }

    @Override
    public AppointmentDTO getDetailsBySlotId(int slotId) {
        return appointmentFeign.getDetailsBySlotId((long) slotId);
    }


    @Override
    public void updateAppointment(Integer id, AppointmentStatus appointmentStatus) {
        appointmentFeign.updateAppointment(id, appointmentStatus);

    }

    @Override
    public void deleteAppointmentBySlotId(int id) {
        appointmentFeign.deleteAppointmentVySlotId((long) id);

    }
}
