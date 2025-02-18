package com.example.Doctor.enums;

//@Getter
public enum Specialization {

    CARDIOLOGIST("cardiologist"),
    NEUROLOGIST("neurologist"),
    ORTHOPEDIC("orthologist"),
    GYNAECOLOGIST("gynaecologist");

    private final String value;

    Specialization(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
