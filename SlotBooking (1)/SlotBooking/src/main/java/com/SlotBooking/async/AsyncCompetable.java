package com.SlotBooking.async;

import com.SlotBooking.feign.AppointmentAvailabilityFeign;
import com.SlotBooking.feign.DoctorFeign;
import com.SlotBooking.feign.PatientFeign;
import com.SlotBooking.model.AppointmentDTO;
import com.SlotBooking.model.DoctorResponse;
import com.SlotBooking.model.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncCompetable {

    @Autowired
    private AppointmentAvailabilityFeign appointmentAvailabilityFeign;

    @Autowired
    private DoctorFeign doctorFeign;

    @Autowired
    private PatientFeign patientFeign;

    @Async
    public CompletableFuture<AppointmentDTO> getDetailsBySlotId(Long slotId){


       return CompletableFuture.completedFuture(appointmentAvailabilityFeign.getDetailsBySlotId(slotId));
    }


    @Async
    public CompletableFuture<DoctorResponse> doctorResponsesynccall(Long doctorId) {


        return CompletableFuture.completedFuture(doctorFeign.getDoctordetailsByDoctorId(doctorId));

    }

    @Async
    public CompletableFuture<PatientResponse> patientResponsesynccall(Long doctorId) {


        return CompletableFuture.completedFuture(patientFeign.getPatientDetailsById(doctorId));

    }


}



