package com.hms.patientservice.service;

import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import com.hms.patientservice.DTO.PatientRequestDTO;
import com.hms.patientservice.DTO.PatientResponseDTO;

public interface patientService {

	PatientResponseDTO createPatient(PatientRequestDTO request);

	PatientResponseDTO getPatientById(Long id);

	Page<PatientResponseDTO> getAllPatients(Pageable pageable);

	PatientResponseDTO updatePatient(Long id, PatientRequestDTO request);

	void deletePatient(Long id);

}
