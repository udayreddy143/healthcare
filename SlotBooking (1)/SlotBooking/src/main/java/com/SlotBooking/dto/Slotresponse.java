package com.SlotBooking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Slotresponse {

	@Getter
    private int slotId;

    private int doctorId;
	@Getter
    private Long patientId;

}
