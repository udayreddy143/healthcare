package com.SlotBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SlotBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlotBookingApplication.class, args);
	}

}
