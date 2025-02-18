package com.hospital.patient.service;

import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.dto.PatientResponse;

public interface PatientService {
    void savePatientDetails(PatientRequest patientRequest);
    PatientResponse getPatientDetailsByID(Long id);

    Long getPatientDetailsByDoctorId(Long doctorId);

    void updatePatientDetails(Long id, PatientRequest patientRequest);
    void deletePatientDetails(Long id);
}
