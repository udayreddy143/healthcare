package com.example.Doctor.model;

import com.example.Doctor.enums.Specialization;
import lombok.Data;

@Data
//@RequiredArgsConstructor
public class DoctorRequest {

        private String name;
        private Specialization specialization;
        private double experience;


}
