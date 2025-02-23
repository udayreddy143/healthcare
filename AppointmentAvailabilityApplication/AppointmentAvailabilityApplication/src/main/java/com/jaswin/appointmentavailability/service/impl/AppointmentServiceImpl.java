package com.jaswin.appointmentavailability.service.impl;

import com.jaswin.appointmentavailability.dao.AppointmentRepository;
import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import com.jaswin.appointmentavailability.entity.AppointmentAvailability;
import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import com.jaswin.appointmentavailability.model.AppointmentRequest;
import com.jaswin.appointmentavailability.service.AppointmentService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public void testService() {
        System.out.println("Service method is executed .....");
    }

    @Override
    public void storeAppointments(AppointmentRequest appointmentRequest) {
        AppointmentAvailability appointmentAvailability = new AppointmentAvailability();
        appointmentAvailability.setDoctorId(appointmentRequest.getDoctorId());
        appointmentAvailability.setStartTime(appointmentRequest.getStartTime());
        appointmentAvailability.setEndTime(appointmentRequest.getEndTime());
        appointmentAvailability.setStatus(appointmentRequest.getStatus().getValue());
        appointmentRepository.save(appointmentAvailability);

    }



    public AppointmentDTO getAppointmentsByDoctorId(int doctorId) {

        Optional<AppointmentAvailability> response = appointmentRepository.findByDoctorId(doctorId);

        if (response.isPresent()) {
            AppointmentAvailability appointmentAvailability = response.get();
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setSlotId(appointmentAvailability.getSlotId());
            appointmentDTO.setDoctorId(appointmentAvailability.getDoctorId());
            appointmentDTO.setStartTime(appointmentAvailability.getStartTime());
            appointmentDTO.setEndTime(appointmentAvailability.getEndTime());
            appointmentDTO.setStatus(appointmentAvailability.getStatus());
            return appointmentDTO;


        }
        return null;
    }




    @Override
    public AppointmentDTO getDetailsBySlotId(int slotId) {
        Optional<AppointmentAvailability> response = appointmentRepository.findById(slotId);

        if (response.isPresent()) {
            AppointmentAvailability appointmentAvailability = response.get();
                AppointmentDTO appointmentDTO = new AppointmentDTO();
                appointmentDTO.setSlotId(appointmentAvailability.getSlotId());
                appointmentDTO.setDoctorId(appointmentAvailability.getDoctorId());
                appointmentDTO.setStartTime(appointmentAvailability.getStartTime());
                appointmentDTO.setEndTime(appointmentAvailability.getEndTime());
                appointmentDTO.setStatus(appointmentAvailability.getStatus());
                return appointmentDTO;


        }
        return null;
    }








    @Override
    public void updateAppointment(Integer id, AppointmentStatus appointmentStatus) {
        Optional<AppointmentAvailability> response = appointmentRepository.findBySlotId(id);
        if(response.isPresent()) {
            AppointmentAvailability appointmentAvailability = response.get();
            appointmentAvailability.setStatus(appointmentStatus.getValue());
            appointmentRepository.save(appointmentAvailability);
        }

    }

    @Override
    public void deleteAppointmentBySlotId(int id) {
        appointmentRepository.deleteById(id);

    }
}
