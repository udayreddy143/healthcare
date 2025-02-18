package com.SlotBooking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SlotBooking.Entity.Slotentity;
@Repository

public interface Slotrepository extends JpaRepository<Slotentity, Long>{
	List<Slotentity>  findBySlotId(Long SlotId);

	Optional<Slotentity>  findBySlotIdAndDoctorIdAndPatientId(Long SlotId, Long doctorId, Long patientId);
	
}
