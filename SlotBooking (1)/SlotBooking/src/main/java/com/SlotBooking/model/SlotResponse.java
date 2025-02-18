package com.SlotBooking.model;

public class SlotResponse {
	private Long patientId;
	private Long DoctorId;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(Long doctorId) {
		DoctorId = doctorId;
	}


}
