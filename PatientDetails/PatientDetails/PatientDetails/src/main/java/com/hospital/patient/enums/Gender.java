package com.hospital.patient.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;



public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String value;
        Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
