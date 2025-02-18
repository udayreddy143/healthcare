package com.hospital.patient.dao;

import com.hospital.patient.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
    PatientEntity findPatientDetailsById(Long id);
    Optional<PatientEntity> findById(Long id);
    @Query("SELECT p FROM PatientEntity p WHERE p.doctorId = ?1 ORDER BY p.id DESC")
    Optional<PatientEntity> findTopByDoctorIdOrderByidDesc(Long doctorId);
}
