package com.jashwin.apigateway.patient.service;


import com.jashwin.apigateway.patient.dto.PatientRequest;
import com.jashwin.apigateway.patient.dto.PatientResponse;

public interface PatientService {
    PatientResponse savePatientDetails(PatientRequest patientRequest);
    PatientResponse getPatientDetailsByID(Long id);

    PatientResponse getPatientDetailsByDoctorId(Long doctorId);

    void updatePatientDetails(Long id, PatientRequest patientRequest);
    void deletePatientDetails(Long id);
}
