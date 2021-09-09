package com.backendphase.converter;

import org.springframework.stereotype.Component;

import com.backendphase.dto.PhaseDTO;
import com.backendphase.entity.PhaseEntity;

@Component
public class PhaseConverter {

	public PhaseDTO convertToPhaseDTO(PhaseEntity phaseEntity) {
		PhaseDTO phaseDTO = new PhaseDTO();
		phaseDTO.setId(phaseEntity.getId());
		phaseDTO.setName(phaseEntity.getName());
		phaseDTO.setDescription(phaseEntity.getDescription());

		return phaseDTO;
	}

	public PhaseEntity convertToPhaseEntity(PhaseDTO phaseDTO) {
		PhaseEntity phaseEntity = new PhaseEntity();
		phaseEntity.setName(phaseDTO.getName());
		phaseEntity.setDescription(phaseDTO.getDescription());

		return phaseEntity;
	}
	
	public PhaseEntity convertToPhaseEntity(PhaseEntity phaseEntity, PhaseDTO phaseDTO) {
		phaseEntity.setName(phaseDTO.getName());
		phaseEntity.setDescription(phaseDTO.getDescription());
		
		return phaseEntity;
	}

}
