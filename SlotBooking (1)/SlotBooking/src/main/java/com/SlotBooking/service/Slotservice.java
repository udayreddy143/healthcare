package com.SlotBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.SlotBooking.async.AsyncCompetable;
import com.SlotBooking.feign.AppointmentAvailabilityFeign;
import com.SlotBooking.feign.DoctorFeign;
import com.SlotBooking.feign.PatientFeign;
import com.SlotBooking.model.AppointmentDTO;
import com.SlotBooking.model.DoctorPatientResponse;
import com.SlotBooking.model.DoctorResponse;
import com.SlotBooking.model.PatientResponse;
import com.SlotBooking.model.SlotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SlotBooking.Entity.Slotentity;
import com.SlotBooking.Repository.Slotrepository;
import com.SlotBooking.dto.Slotresponse;
import com.SlotBooking.model.Slotrequest;
@Service
public class Slotservice {
	@Autowired
	private Slotrepository slotrepository;

	@Autowired
	private AppointmentAvailabilityFeign appointmentAvailabilityFeign;

	@Autowired
	private PatientFeign patientFeign;

	@Autowired
	private AsyncCompetable asyncCompetable;

	@Autowired
	private DoctorFeign doctorFeign;
	public SlotResponse indata(Slotrequest slotrequest){

		//I need to update in appoinmnet status in appointment table  based on the slotId

		updateStatusInAppointmentTableWithBooked(slotrequest.getSlotId());

		// connect with pateint service passing doctorId to get the patentDetails

		 Integer patientId = getPatientDetails(slotrequest.getDoctorId());

		Slotentity slotentity=new Slotentity();
		slotentity.setSlotId(slotrequest.getSlotId());
		slotentity.setPatientId(Long.valueOf(patientId));
		slotentity.setDoctorId(slotrequest.getDoctorId());
		Slotentity slotentity1 =slotrepository.save(slotentity);

		SlotResponse res=new SlotResponse();
		res.setDoctorId(slotentity1.getDoctorId());
		res.setPatientId(slotentity1.getPatientId());
		res.setId(slotentity1.getId());

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
		List<Slotentity> slotentity= slotrepository.findBySlotId(slotId);
		List<Slotresponse> responseList = new ArrayList<>();
		for(Slotentity slotentity2:slotentity) {
			Slotresponse slotresponse = new Slotresponse();
			slotresponse.setSlotId(slotentity2.getSlotId());
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
			CompletableFuture<DoctorResponse> doctorResponse1 = asyncCompetable.doctorResponsesynccall(slotentity.getDoctorId());
//			DoctorResponse doctorResponse =doctorFeign.getDoctordetailsByDoctorId(slotentity.getDoctorId());
			CompletableFuture<PatientResponse> patientResponse1 = asyncCompetable.patientResponsesynccall(slotentity.getDoctorId());
//			PatientResponse patientResponse = patientFeign.getPatientDetailsById(slotentity.getDoctorId());
			CompletableFuture<AppointmentDTO> appointmentDTO1 = asyncCompetable.getDetailsBySlotId(slotentity.getSlotId());
//			AppointmentDTO appointmentDTO = appointmentAvailabilityFeign.getDetailsBySlotId(slotentity.getSlotId());
			CompletableFuture.allOf(doctorResponse1,patientResponse1,appointmentDTO1).join();

            DoctorResponse doctorResponse = doctorResponse1.join();
			PatientResponse patientResponse = patientResponse1.join();
			AppointmentDTO appointmentDTO = appointmentDTO1.join();

			doctorPatientResponse.setDoctorName(doctorResponse.getName());
			doctorPatientResponse.setSpecialization(doctorResponse.getSpecialization());
			doctorPatientResponse.setPatientName(patientResponse.getName());
			doctorPatientResponse.setStatus(appointmentDTO.getStatus());
			doctorPatientResponse.setPatientId(patientResponse.getId());
			doctorPatientResponse.setDisease(patientResponse.getDisease());
			doctorPatientResponse.setGender(patientResponse.getGender());
			doctorPatientResponse.setPatientAddress(patientResponse.getAddress());
			doctorPatientResponse.setAppointmentStartTime(appointmentDTO.getStartiime());
			doctorPatientResponse.setAppointmentEndtime(appointmentDTO.getEndtime());
			doctorPatientResponses.add(doctorPatientResponse);




		}
		return doctorPatientResponses;

	}

}
