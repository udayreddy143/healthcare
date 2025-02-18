package com.example.Doctor.repository;

import com.example.Doctor.entity.DoctorEntity;
import com.example.Doctor.entity.SpecDisRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecDiseaseRepository extends JpaRepository<SpecDisRelationEntity, Integer> {
}
