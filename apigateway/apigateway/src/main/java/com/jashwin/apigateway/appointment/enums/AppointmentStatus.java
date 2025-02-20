package com.jashwin.apigateway.appointment.enums;

public enum AppointmentStatus {
    AVAILABLE("available"),
    NOT_AVAILABLE("notavailable"),
    BOOKED("booked");

    // Private field to store the string value
    private final String value;

    // Constructor to initialize the string value
    AppointmentStatus(String value) {
        this.value = value;
    }

    // Getter to retrieve the string value
    public String getValue() {
        return value;
    }
}
