package com.backendphase.service;

import java.util.List;

import com.backendphase.dto.PhaseDTO;

public interface IPhaseService {

	List<PhaseDTO> findAll();

	PhaseDTO findById(Long id);

	PhaseDTO save(PhaseDTO phaseDTO);

	void delete(Long id);

}
