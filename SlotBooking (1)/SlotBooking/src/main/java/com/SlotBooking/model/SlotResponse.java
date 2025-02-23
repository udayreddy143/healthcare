package com.SlotBooking.model;

import lombok.Getter;
import lombok.Setter;

public class SlotResponse {
	@Setter
    private Long patientId;
	private int doctorId;

	@Setter
    @Getter
    private Long id;

    public Long getPatientId() {
		return patientId;
	}

    public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


}
