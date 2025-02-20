package com.jashwin.apigateway.doctor.model;

import lombok.Data;

@Data
public class DoctorResponse {

    private int id;
    private String name;
    private String specialization;
    private double experience;

}
