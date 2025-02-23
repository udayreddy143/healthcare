package com.SlotBooking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class AppointmentDTO {
    private int slotId;
    private int doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

}
