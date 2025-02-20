package com.jashwin.apigateway.doctor.model;


import com.jashwin.apigateway.doctor.enums.Specialization;
import lombok.Data;

@Data
//@RequiredArgsConstructor
public class DoctorRequest {

        private String name;
        private Specialization specialization;
        private double experience;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Specialization getSpecialization() {
                return specialization;
        }

        public void setSpecialization(Specialization specialization) {
                this.specialization = specialization;
        }

        public double getExperience() {
                return experience;
        }

        public void setExperience(double experience) {
                this.experience = experience;
        }
}
