package com.SlotBooking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.SlotBooking.feign.AppointmentAvailabilityFeign;
import com.SlotBooking.feign.DoctorFeign;
import com.SlotBooking.feign.PatientFeign;
import com.SlotBooking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SlotBooking.Entity.Slotentity;
import com.SlotBooking.Repository.Slotrepository;
import com.SlotBooking.dto.Slotresponse;

@Service
public class Slotservice {
	@Autowired
	private Slotrepository slotrepository;

	@Autowired
	private AppointmentAvailabilityFeign appointmentAvailabilityFeign;

	@Autowired
	private PatientFeign patientFeign;

	@Autowired
	private DoctorFeign doctorFeign;
	public SlotResponse indata(Slotrequest slotrequest){

		//I need to update in appoinmnet status in appointment table  based on the slotId

		updateStatusInAppointmentTableWithBooked((long) slotrequest.getSlotId());

		// connect with pateint service passing doctorId to get the patentDetails

		 long patientId = getPatientDetails((long) slotrequest.getDoctorId());

		Slotentity slotentity=new Slotentity();
		slotentity.setSlotId(slotrequest.getSlotId());
		slotentity.setPatientId(patientId);
		slotentity.setDoctorId(slotrequest.getDoctorId());
		Slotentity slotentity1 =slotrepository.save(slotentity);

		SlotResponse res=new SlotResponse();
		res.setDoctorId(slotentity1.getDoctorId());
		res.setPatientId(slotentity1.getPatientId());
		res.setId((long) slotentity1.getId());

		return res;

	}

	void updateStatusInAppointmentTableWithBooked(Long slotId){

		//need to write feign to connect appointment service to update the status
		appointmentAvailabilityFeign.updateStatusInAppointmentService(slotId,"BOOKED");
	}

	private Integer getPatientDetails(Long doctorId) {

		return  patientFeign.getPatientIdByUsingDoctorId(doctorId);

	}

	public List<Slotresponse> getdata(Long slotId) {
		List<Slotentity> slotentity= slotrepository.findBySlotId(Math.toIntExact(slotId));
		List<Slotresponse> responseList = new ArrayList<>();
		for(Slotentity slotentity2:slotentity) {
			Slotresponse slotresponse = new Slotresponse();
			slotresponse.setSlotId(Math.toIntExact(slotentity2.getSlotId()));
			slotresponse.setPatientId(slotentity2.getPatientId());
			slotresponse.setDoctorId(slotentity2.getDoctorId());
			responseList.add(slotresponse);
		}
		return responseList;

	}

//	public Slotrequest updata(Slotrequest slotrequest){
//		Optional<Slotentity> slotentity = slotrepository.findById(slotrequest.getId());
//		Slotentity slotentity2=slotentity.get();
//		slotentity2.setSlotId(slotrequest.getSlotId());
//		slotentity2.setPatientId(slotrequest.getPatientId());
//		slotentity2.setDoctorId(slotrequest.getDoctorId());
//
//		Slotentity slotentity3= slotrepository.save(slotentity2);
//
//
//		return slotrequest;
//	}


	public String deletedata(Long id) {
		slotrepository.deleteById(id);
		return "deleted ";
	}


	public List<DoctorPatientResponse> getDoctorPatientDetails(){

		List<Slotentity> slotentities = slotrepository.findAll();

		List<DoctorPatientResponse> doctorPatientResponses = new ArrayList<>();
		for(Slotentity slotentity: slotentities){


			DoctorPatientResponse doctorPatientResponse = new DoctorPatientResponse();
			DoctorResponse doctorResponse =doctorFeign.getDoctordetailsByDoctorId(slotentity.getDoctorId());
			PatientResponse patientResponse = patientFeign.getPatientDetailsById(slotentity.getPatientId());
			AppointmentDTO appointmentDTO = appointmentAvailabilityFeign.getDetailsBySlotId(Math.toIntExact(slotentity.getSlotId()));

			doctorPatientResponse.setDoctorName(doctorResponse.getName());
			doctorPatientResponse.setSpecialization(doctorResponse.getSpecialization());
			doctorPatientResponse.setPatientName(patientResponse.getName());
			doctorPatientResponse.setStatus(appointmentDTO.getStatus());
			doctorPatientResponse.setPatientId(patientResponse.getId());
			doctorPatientResponse.setDisease(patientResponse.getDisease());
			doctorPatientResponse.setGender(patientResponse.getGender());
			doctorPatientResponse.setPatientAddress(patientResponse.getAddress());
			doctorPatientResponse.setAppointmentStartTime(appointmentDTO.getStartTime());
			doctorPatientResponse.setAppointmentEndtime(appointmentDTO.getEndTime());
			doctorPatientResponses.add(doctorPatientResponse);




		}
		return doctorPatientResponses;

	}

	public List<DoctorSlotPatientResponse> getAllDetailsByDoctor(int doctorId) {
		// Fetch slots for the given doctor ID
		List<Slotentity> slotEntities = slotrepository.findByDoctorId(doctorId);


		// Return an empty list if no slots exist for the doctor
		if (slotEntities.isEmpty()) {
			return Collections.emptyList();
		}

		List<DoctorSlotPatientResponse> doctorSlotPatientResponses = new ArrayList<>();

		for (Slotentity slotEntity : slotEntities) {
			DoctorSlotPatientResponse response = new DoctorSlotPatientResponse();
			response.setSlotId(slotEntity.getSlotId());
			response.setDoctorId(slotEntity.getDoctorId());
			response.setPatientId(slotEntity.getPatientId());
			DoctorResponse doctorResponse =doctorFeign.getDoctordetailsByDoctorId(slotEntity.getDoctorId());
			PatientResponse patientResponse = patientFeign.getPatientDetailsById(slotEntity.getPatientId());


			// Fetch appointment details safely
			AppointmentDTO appointmentDTO = appointmentAvailabilityFeign.getAppointmentsByDoctorId(slotEntity.getDoctorId());

			response.setDoctorName(doctorResponse.getName());
			response.setSpecialization(doctorResponse.getSpecialization());
			response.setExperience(doctorResponse.getExperience());
			response.setPatientName(patientResponse.getName());
			response.setPatientAge(patientResponse.getAge());
			response.setPatientId(patientResponse.getId());
			response.setDisease(patientResponse.getDisease());
			response.setGender(patientResponse.getGender());
			response.setPatientAddress(patientResponse.getAddress());
			response.setAppointmentStartTime(appointmentDTO.getStartTime());
			response.setAppointmentEndTime(appointmentDTO.getEndTime());
			response.setStatus(appointmentDTO.getStatus());

			doctorSlotPatientResponses.add(response);
		}
		return doctorSlotPatientResponses;
	}


}


