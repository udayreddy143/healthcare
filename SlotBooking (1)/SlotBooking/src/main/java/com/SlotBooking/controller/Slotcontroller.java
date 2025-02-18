package com.SlotBooking.controller;

import java.util.List;

import com.SlotBooking.model.DoctorPatientResponse;
import com.SlotBooking.model.SlotResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Slotresponse> getdata(@PathVariable Long slotId) {
	return slotservice.getdata(slotId);
	}
//	@PutMapping("/upput")
//	public Slotrequest updata(@RequestBody Slotrequest slotrequest){
//		return slotservice.updata(slotrequest);
//
//	}

	@DeleteMapping("/datadelete/{id}")
	public String deletedata(@PathVariable Long id) {
	return slotservice.deletedata(id);
//	 return "deleted ";
	}


	@GetMapping("/getDoctorPatientDetails")
	public List<DoctorPatientResponse> getDoctorPatientDetails() {
		return slotservice.getDoctorPatientDetails();
	}


}
