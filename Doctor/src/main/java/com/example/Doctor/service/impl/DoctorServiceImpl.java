package com.example.Doctor.service.impl;

import com.example.Doctor.configuration.RedisDoctorCache;
import com.example.Doctor.entity.DoctorEntity;
import com.example.Doctor.entity.SpecDisRelationEntity;
import com.example.Doctor.model.DoctorRequest;
import com.example.Doctor.model.DoctorResponse;
import com.example.Doctor.repository.DoctorRepository;
import com.example.Doctor.repository.SpecDiseaseRepository;
import com.example.Doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

//@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private  final SpecDiseaseRepository specDiseaseRepository;



    @Autowired
    RedisDoctorCache doctorCache;

    @Override
    public DoctorResponse storedoctordetails(DoctorRequest request) {

        DoctorEntity entity = new DoctorEntity();
        entity.setName(request.getName());
        entity.setSpecialization(String.valueOf(request.getSpecialization()));
        entity.setExperience(request.getExperience());
        DoctorEntity savedEntity = doctorRepository.save(entity);
        DoctorResponse response = new DoctorResponse();
        response.setId(savedEntity.getId());
        response.setName(savedEntity.getName());
        response.setSpecialization(savedEntity.getSpecialization());
        response.setExperience(savedEntity.getExperience());
        return response;

    }

    @Override
    public DoctorResponse storeRelatedDisease(String spec, Set<String> dis) {


        List<SpecDisRelationEntity> list = new ArrayList<>();
        for(String str:dis) {
            SpecDisRelationEntity entity = new SpecDisRelationEntity();
            entity.setSpecialization(spec);
            entity.setDiseaseName(str);
            list.add(entity);
        }
        specDiseaseRepository.saveAll(list);
        return null;

    }

    @Override
    public Map<String, List<String>> getRelatedDisease() {

      Map<String,List<String>> diseasesRelated = new HashMap<>();

        List<SpecDisRelationEntity> entity =specDiseaseRepository.findAll();

        for(SpecDisRelationEntity relation:entity) {
            if(diseasesRelated.containsKey(relation.getSpecialization())) {
                diseasesRelated.get(relation.getSpecialization()).add(relation.getDiseaseName());
            } else {
                List<String> disList = new ArrayList<>();
                disList.add(relation.getDiseaseName());
                diseasesRelated.put(relation.getSpecialization(), disList);
            }
        }

//        List<SpecDisRelationEntity> list = new ArrayList<>();
//        for(String str:dis) {
//            SpecDisRelationEntity entity = new SpecDisRelationEntity();
//            entity.setSpecialization(spec);
//            entity.setDiseaseName(str);
//            list.add(entity);
//        }
      //  specDiseaseRepository.saveAll(list);
        return diseasesRelated;

    }

    @Override
    public List<DoctorResponse> getDoctordetails() {

        //Bucket

        List<DoctorEntity> savedEntity = doctorRepository.findAll();
        List<DoctorResponse> responseList = new ArrayList<>();
        for(DoctorEntity entity:savedEntity) {
            DoctorResponse response = new DoctorResponse();
            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setSpecialization(entity.getSpecialization());
            response.setExperience(entity.getExperience());
            responseList.add(response);
        }
        return responseList;

    }

    @Override
    public DoctorResponse getDoctordetailsById(Integer doctorId){

        if(doctorCache.checkData(doctorId.toString())) {
            System.out.println("return data from cache");
            return doctorCache.get(doctorId.toString());
        }
        Optional<DoctorEntity> doctorResponse = doctorRepository.findById(doctorId);
        //here i ned to redis template to cache the data
        if(doctorResponse.isPresent()) {
            System.out.println("getting data from reposity");
            DoctorEntity entity = doctorResponse.get();
            DoctorResponse doctorResponse1 = new DoctorResponse();
            doctorResponse1.setName(entity.getName());
            doctorResponse1.setSpecialization(entity.getSpecialization());
            doctorResponse1.setExperience(entity.getExperience());
            //store data intpo the cache
            doctorCache.put(doctorId.toString(),doctorResponse1);
            return doctorResponse1;

        }
        return null;
    }
}

