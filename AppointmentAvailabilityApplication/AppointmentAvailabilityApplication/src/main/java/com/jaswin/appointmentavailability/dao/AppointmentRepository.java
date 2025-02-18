package com.jaswin.appointmentavailability.dao;

import com.jaswin.appointmentavailability.entity.AppointmentAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentAvailability, Integer> {
    //Optional<List<AppointmentAvailability>> findByDoctorid(int doctorId);

    Optional<List<AppointmentAvailability>> findByDoctoridAndStatus(int doctorId,String status);

    Optional<AppointmentAvailability> findBySlotid(int slotId);
}
