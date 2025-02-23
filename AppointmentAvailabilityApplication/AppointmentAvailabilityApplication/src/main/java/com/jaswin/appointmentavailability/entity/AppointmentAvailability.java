package com.jaswin.appointmentavailability.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_availability")
@Setter
@Getter
public class AppointmentAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "slotid")
    private int slotId;
    @Column(name = "doctorid")
    private int doctorId;
    @Column(name = "starttime")
    private LocalDateTime startTime;
    @Column(name = "endtime")
    private LocalDateTime endTime;
    private String status;

}
