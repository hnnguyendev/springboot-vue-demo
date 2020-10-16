package com.backendphase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backendphase.converter.PhaseConverter;
import com.backendphase.dto.PhaseDTO;
import com.backendphase.entity.PhaseEntity;
import com.backendphase.repository.IPhaseRepository;
import com.backendphase.service.IPhaseService;

@Service
public class PhaseServiceImpl implements IPhaseService {

	@Autowired
	private IPhaseRepository phaseRepository;

	@Autowired
	private PhaseConverter phaseConverter;

	@Override
	public List<PhaseDTO> findAll() {
		List<PhaseDTO> phaseDTOList = new ArrayList<>();
		List<PhaseEntity> phaseEntityList = phaseRepository.findAll();
		for (PhaseEntity item : phaseEntityList) {
			PhaseDTO phaseDTO = phaseConverter.convertToPhaseDTO(item);
			phaseDTOList.add(phaseDTO);
		}

		return phaseDTOList;
	}

	@Override
	public PhaseDTO findById(Long id) {
		PhaseEntity phaseEntity = phaseRepository.findById(id).get();

		return phaseConverter.convertToPhaseDTO(phaseEntity);
	}

	@Override
	@Transactional
	public PhaseDTO save(PhaseDTO phaseDTO) {
		PhaseEntity phaseEntity = new PhaseEntity();
		if (phaseDTO.getId() != null) {
			PhaseEntity oldPhase = phaseRepository.getOne(phaseDTO.getId());
			phaseEntity = phaseConverter.convertToPhaseEntity(oldPhase, phaseDTO);
		} else {
			phaseEntity = phaseConverter.convertToPhaseEntity(phaseDTO);
		}

		return phaseConverter.convertToPhaseDTO(phaseRepository.save(phaseEntity));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		phaseRepository.deleteById(id);
	}

}
