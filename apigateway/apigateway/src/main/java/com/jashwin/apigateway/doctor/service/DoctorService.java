package com.jashwin.apigateway.doctor.service;



import com.jashwin.apigateway.doctor.model.DoctorRequest;
import com.jashwin.apigateway.doctor.model.DoctorResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DoctorService {

    DoctorResponse storedoctordetails(DoctorRequest request);

    DoctorResponse storeRelatedDisease(String spec, Set<String> dis);

    Map<String, List<String>> getRelatedDisease();

    List<DoctorResponse> getDoctordetails();

    DoctorResponse getDoctordetailsById(Integer doctorId);
}
