package com.example.Doctor.configuration;


import com.example.Doctor.repository.DoctorRepository;
import com.example.Doctor.repository.SpecDiseaseRepository;
import com.example.Doctor.service.DoctorService;
import com.example.Doctor.service.impl.DoctorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfig {

    @Bean
    DoctorService doctorService(DoctorRepository doctorRepository, SpecDiseaseRepository specDiseaseRepository) {
        return new DoctorServiceImpl(doctorRepository,specDiseaseRepository);
    }
}
