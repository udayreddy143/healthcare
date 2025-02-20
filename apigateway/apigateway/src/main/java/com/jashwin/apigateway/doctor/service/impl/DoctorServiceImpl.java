package com.jashwin.apigateway.doctor.service.impl;


import com.jashwin.apigateway.doctor.feign.DoctorFeign;
import com.jashwin.apigateway.doctor.model.DoctorRequest;
import com.jashwin.apigateway.doctor.model.DoctorResponse;
import com.jashwin.apigateway.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

//@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private DoctorFeign doctorFeign;


    @Override
    public DoctorResponse storedoctordetails(DoctorRequest request) {

        return doctorFeign.storeDoctorDetails(request);

    }

    @Override
    public DoctorResponse storeRelatedDisease(String spec, Set<String> dis) {

        return null;
    }

    @Override
    public Map<String, List<String>> getRelatedDisease() {

        return null;
    }

    @Override
    public List<DoctorResponse> getDoctordetails() {
        return null;

    }

    @Override
    public DoctorResponse getDoctordetailsById(Integer doctorId) {

        return null;
    }
}
