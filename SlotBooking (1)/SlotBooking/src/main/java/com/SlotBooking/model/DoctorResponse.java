package com.SlotBooking.model;

import lombok.Getter;

public class DoctorResponse {

    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String specialization;
    private double experience;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return (int) experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }
}
