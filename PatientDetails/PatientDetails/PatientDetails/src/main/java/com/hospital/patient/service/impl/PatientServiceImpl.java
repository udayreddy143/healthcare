package com.hospital.patient.service.impl;

import com.hospital.patient.dao.PatientRepository;
import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.dto.PatientResponse;
import com.hospital.patient.entity.PatientEntity;
import com.hospital.patient.service.PatientService;

import java.util.Optional;

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
   this.patientRepository=patientRepository;
    }

    @Override
    public void savePatientDetails(PatientRequest patientRequest) {
        PatientEntity patientEntity=new PatientEntity();
        patientEntity.setName(patientRequest.getName());
        patientEntity.setAddress(patientRequest.getAddress());
        patientEntity.setAge(patientRequest.getAge());
        patientEntity.setGender(patientRequest.getGender());
        patientEntity.setDisease(patientRequest.getDisease());
        patientEntity.setDoctorId(patientRequest.getDoctorId());
        patientRepository.save(patientEntity);
        System.out.println("patient details saved");

    }

    @Override
    public PatientResponse getPatientDetailsByID(Long id) {
        PatientResponse patientResponse=new PatientResponse();
        PatientEntity patientEntity= patientRepository.findPatientDetailsById(id);
        patientResponse.setId(patientEntity.getId());
        patientResponse.setAddress(patientEntity.getAddress());
        patientResponse.setAge(patientEntity.getAge());
        patientResponse.setName(patientEntity.getName());
        patientResponse.setGender(String.valueOf(patientEntity.getGender()));
        patientResponse.setDisease(patientEntity.getDisease());
        return patientResponse;
    }

    @Override
    public Long getPatientDetailsByDoctorId(Long doctorId) {
        Optional<PatientEntity> patientEntity= patientRepository.findTopByDoctorIdOrderByidDesc(doctorId);

        if(patientEntity.isPresent()) {
            return patientEntity.get().getId();
        }
        return null;
    }

    @Override
    public void updatePatientDetails(Long id, PatientRequest patientRequest) {
        Optional<PatientEntity> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {
            PatientEntity patientEntity = optionalPatient.get();
            patientEntity.setName(patientRequest.getName());
            patientEntity.setAddress(patientRequest.getAddress());
            patientEntity.setAge(patientRequest.getAge());
            patientEntity.setGender(patientRequest.getGender());
            patientEntity.setDisease(patientRequest.getDisease());
            patientRepository.save(patientEntity);

        }
    }

    @Override
    public void deletePatientDetails(Long id) {
        patientRepository.deleteById(id);

    }
}
