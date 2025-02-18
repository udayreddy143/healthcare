package com.hospital.patient.config;

import com.hospital.patient.dao.PatientRepository;
import com.hospital.patient.service.PatientService;
import com.hospital.patient.service.impl.PatientServiceImpl;
import org.hibernate.annotations.Bag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {

    @Bean
    PatientService patientService(PatientRepository patientRepository) {
        return new PatientServiceImpl (patientRepository);
    }
}
