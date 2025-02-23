package com.SlotBooking.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class DoctorPatientResponse {

    private int id;
    private String doctorName;
    private String specialization;
    private double experience;
    private Long patientId;
    private String patientName;
    private String patientAddress;
    private int patientAge;
    private String disease;
    private String gender;
    private String patientDescription;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndtime;
    private String status;

}
