package com.jaswin.appointmentavailability.entity;

import com.jaswin.appointmentavailability.enums.AppointmentStatus;
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
    private int slotid;
    private int doctorid;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private String status;

}
