package com.SlotBooking.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="slottable")
public class Slotentity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int slotId;
    @Column(name = "doctorid")
    private int doctorId;
    private Long patientId;

}
