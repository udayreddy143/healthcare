package com.jaswin.appointmentavailability.config;

import com.jaswin.appointmentavailability.dao.AppointmentRepository;
import com.jaswin.appointmentavailability.service.AppointmentService;
import com.jaswin.appointmentavailability.service.impl.AppointmentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {
    @Bean
    AppointmentService appointmentService(AppointmentRepository appointmentRepository) {
        return new AppointmentServiceImpl(appointmentRepository);
    }
}
