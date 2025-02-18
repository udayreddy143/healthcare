package com.jaswin.appointmentavailability.model;

import com.jaswin.appointmentavailability.enums.AppointmentStatus;
import lombok.Data;

@Data
public class UpdateAppointmentRequest {
    private int doctorid;
    private AppointmentStatus status;
}
