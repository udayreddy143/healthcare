package com.example.Doctor.service;

import com.example.Doctor.model.DoctorRequest;
import com.example.Doctor.model.DoctorResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DoctorService {

    DoctorResponse storedoctordetails(DoctorRequest request);

    DoctorResponse storeRelatedDisease(String spec, Set<String> dis);

    Map<String, List<String>> getRelatedDisease();

    List<DoctorResponse> getDoctordetails();

    DoctorResponse getDoctordetailsByDoctorId(int doctorId);
}
