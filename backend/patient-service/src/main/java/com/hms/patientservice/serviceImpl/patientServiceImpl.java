package com.hms.patientservice.serviceImpl;

import java.awt.print.Pageable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import com.hms.patientservice.DTO.PatientRequestDTO;
import com.hms.patientservice.DTO.PatientResponseDTO;
import com.hms.patientservice.entity.Patient;
import com.hms.patientservice.mapper.PatientMapper;
import com.hms.patientservice.service.patientService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class patientServiceImpl implements patientService {
	
	private PatientMapper patientMapper;
	
	private static final Logger log = LoggerFactory.getLogger(patientServiceImpl.class);

	@Override
	public PatientResponseDTO createPatient(PatientRequestDTO request) {
		log.info("creation of patient Start");
		
		
		
		
		
		return null;
	}

	@Override
	public PatientResponseDTO getPatientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PatientResponseDTO> getAllPatients(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientResponseDTO updatePatient(Long id, PatientRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		
	}

}
