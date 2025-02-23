package com.SlotBooking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
public class DoctorSlotPatientResponse {

    // Doctor Details
    private int doctorId;
    private String doctorName;
    private String specialization;
    private double experience;

    // Slot Details
    private int slotId;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;
    private String status;

    // Patient Details
    private long patientId;
    private String patientName;
    private int patientAge;
    private String patientAddress;
    private String disease;
    private String gender;



}

