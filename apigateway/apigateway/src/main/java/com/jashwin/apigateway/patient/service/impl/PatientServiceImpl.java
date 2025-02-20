package com.jashwin.apigateway.patient.service.impl;



import com.jashwin.apigateway.patient.dto.PatientRequest;
import com.jashwin.apigateway.patient.dto.PatientResponse;

import com.jashwin.apigateway.patient.feign.PatientFeign;
import com.jashwin.apigateway.patient.service.PatientService;


public class PatientServiceImpl implements PatientService {

    private PatientFeign patientFeign;


    @Override
    public PatientResponse savePatientDetails(PatientRequest patientRequest) {

        return patientFeign.savePatientDetails(patientRequest);
    }

    @Override
    public PatientResponse getPatientDetailsByID(Long id) {
       return patientFeign.getPatientDetails(id);
    }

    @Override
    public PatientResponse getPatientDetailsByDoctorId(Long doctorId) {
        return patientFeign.getPatientDetailsByDoctorId(doctorId);
    }

    @Override
    public void updatePatientDetails(Long id, PatientRequest patientRequest) {
        patientFeign.updatePatientDetails(id, patientRequest);

    }

    @Override
    public void deletePatientDetails(Long id) {
        patientFeign.deletePatientDetails(id);

    }
}
