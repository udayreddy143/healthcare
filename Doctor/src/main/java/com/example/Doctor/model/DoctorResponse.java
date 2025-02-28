package com.example.Doctor.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorResponse implements Serializable {
    private int id;
    private String name;
    private String specialization;
    private double experience;

}
