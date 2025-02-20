package com.vishva.admindoctoraccess.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Type {
    Admin ("Admin"),
    Doctor("Doctor");

    private final String value;
    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
