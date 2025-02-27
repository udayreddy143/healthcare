package com.vishva.admindoctoraccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdminDoctorAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDoctorAccessApplication.class, args);
	}

}
