package com.jaswin.appointmentavailability.service.impl;

import com.jaswin.appointmentavailability.dao.AppointmentRepository;
import com.jaswin.appointmentavailability.dto.AppointmentDTO;
import com.jaswin.appointmentavailability.entity.AppointmentAvailability;
import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import com.jaswin.appointmentavailability.model.AppointmentRequest;
import com.jaswin.appointmentavailability.service.AppointmentService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
        appointmentAvailability.setDoctorid(appointmentRequest.getDoctorid());
        appointmentAvailability.setStarttime(appointmentRequest.getStartTime());
        appointmentAvailability.setEndtime(appointmentRequest.getEndTime());
        appointmentAvailability.setStatus(appointmentRequest.getStatus().getValue());
        appointmentRepository.save(appointmentAvailability);

    }

    @Override
    public List<AppointmentDTO> getAppointmentsBySlotId(int doctorId) {
        Optional<List<AppointmentAvailability>> response = appointmentRepository.findByDoctoridAndStatus(doctorId,AppointmentStatus.AVAILABLE.getValue());

        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        //Optional<AppointmentAvailability> appointmentAvailability=appointmentRepository.findById(slotId);
        if (response.isPresent()) {
            List<AppointmentAvailability> appointmentAvailabilityList = response.get();
            for(AppointmentAvailability appointmentAvailability:appointmentAvailabilityList) {
                AppointmentDTO appointmentDTO = new AppointmentDTO();
                appointmentDTO.setSlotid(appointmentAvailability.getSlotid());
                appointmentDTO.setDoctorid(appointmentAvailability.getDoctorid());
                appointmentDTO.setStartiime(appointmentAvailability.getStarttime());
                appointmentDTO.setEndtime(appointmentAvailability.getEndtime());
                appointmentDTO.setStatus(appointmentAvailability.getStatus());
                appointmentDTOList.add(appointmentDTO);
            }
            return appointmentDTOList;
        }
        return null;
    }



    @Override
    public AppointmentDTO getDetailsBySlotId(int slotId) {
        Optional<AppointmentAvailability> response = appointmentRepository.findById(slotId);

        if (response.isPresent()) {
            AppointmentAvailability appointmentAvailability = response.get();
                AppointmentDTO appointmentDTO = new AppointmentDTO();
                appointmentDTO.setSlotid(appointmentAvailability.getSlotid());
                appointmentDTO.setDoctorid(appointmentAvailability.getDoctorid());
                appointmentDTO.setStartiime(appointmentAvailability.getStarttime());
                appointmentDTO.setEndtime(appointmentAvailability.getEndtime());
                appointmentDTO.setStatus(appointmentAvailability.getStatus());
                return appointmentDTO;


        }
        return null;
    }








    @Override
    public void updateAppointment(Integer id, AppointmentStatus appointmentStatus) {
        Optional<AppointmentAvailability> response = appointmentRepository.findBySlotid(id);
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
