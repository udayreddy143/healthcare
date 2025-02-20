package com.jashwin.apigateway.appointment.model;

import com.jashwin.apigateway.appointment.enums.AppointmentStatus;
import lombok.Data;

@Data
public class UpdateAppointmentRequest {
    private int doctorid;
    private AppointmentStatus status;
}
