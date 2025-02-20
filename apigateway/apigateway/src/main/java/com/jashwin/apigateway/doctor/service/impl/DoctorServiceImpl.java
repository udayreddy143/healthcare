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
    public DoctorResponse storeDoctorDetails(DoctorRequest request) {

        return doctorFeign.storeDoctorDetails(request);

    }

    @Override
    public DoctorResponse storeRelatedDisease(String spec, Set<String> dis) {

        return doctorFeign.storeRelatedDisease(spec,dis);
    }

    @Override
    public Map<String, List<String>> getRelatedDisease() {

        return doctorFeign.fetchRelatedDisease();
    }

    @Override
    public List<DoctorResponse> getDoctorDetails() {
        return doctorFeign.getDoctorDetails();

    }

    @Override
    public DoctorResponse getDoctorDetailsById(Integer doctorId) {

        return doctorFeign.getDoctorDetailsById();
    }
}
