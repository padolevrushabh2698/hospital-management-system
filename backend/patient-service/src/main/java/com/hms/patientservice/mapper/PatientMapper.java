package com.hms.patientservice.mapper;

import com.hms.patientservice.DTO.PatientRequestDTO;
import com.hms.patientservice.DTO.PatientResponseDTO;
import com.hms.patientservice.entity.Patient;

public class PatientMapper {
	
	
	
	
	
	public static Patient toEntity(PatientRequestDTO request) {
		if(request==null) {
			return null;
		}
		Patient.builder()
		.name(request.getName()
						.
		
	}
	
	public static PatientResponseDTO mapToResponse(Patient patient) {
		return PatientResponseDTO.builder()
				.id(patient.getId())
				.address(patient.getAddress())
				.name(patient.getName())
				.phone(patient.getPhone())
				.createdAt(patient.getCreatedAt())
				.build();
	}

}
