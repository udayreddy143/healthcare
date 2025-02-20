package com.jashwin.apigateway.appointment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private int doctorid;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime endTime;
    private AppointmentStatus status;
}
