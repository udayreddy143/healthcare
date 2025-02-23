package com.SlotBooking.controller;

import java.util.Collections;
import java.util.List;

import com.SlotBooking.model.DoctorPatientResponse;
import com.SlotBooking.model.DoctorSlotPatientResponse;
import com.SlotBooking.model.SlotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SlotBooking.dto.Slotresponse;
import com.SlotBooking.model.Slotrequest;
import com.SlotBooking.service.Slotservice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/slot")
public class Slotcontroller {
	@Autowired
private Slotservice slotservice;
	
	@PostMapping("/bookslot")
	public SlotResponse indata(@RequestBody Slotrequest slotrequest){
	return slotservice.indata(slotrequest);
		
	}
	@GetMapping("/dataget/{slotId}")
	public List<Slotresponse> getdata(@PathVariable int slotId) {
	return slotservice.getdata((long) slotId);
	}
//	@PutMapping("/upput")
//	public Slotrequest updata(@RequestBody Slotrequest slotrequest){
//		return slotservice.updata(slotrequest);
//
//	}

	@DeleteMapping("/datadelete/{id}")
	public String deletedata(@PathVariable int id) {
	return slotservice.deletedata((long) id);
//	 return "deleted ";
	}


	@GetMapping("/getDoctorPatientDetails")
	public List<DoctorPatientResponse> getDoctorPatientDetails() {
		return slotservice.getDoctorPatientDetails();
	}




	@GetMapping("/doctor/details/{doctorId}")
	public ResponseEntity<List<DoctorSlotPatientResponse>> getAllDetailsByDoctor(@PathVariable int doctorId) {
		List<DoctorSlotPatientResponse> details = slotservice.getAllDetailsByDoctor(doctorId);

		if (details.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		}

		return ResponseEntity.ok(details);
	}

}
