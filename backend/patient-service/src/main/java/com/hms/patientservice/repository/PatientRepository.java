package com.hms.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.patientservice.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
