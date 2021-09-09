package com.backendphase.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendphase.dto.PhaseDTO;
import com.backendphase.service.IPhaseService;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/api")
public class PhaseController {

	@Autowired
	private IPhaseService phaseService;
	
	/* getAll */

//	@GetMapping("/phases")
//	public List<PhaseDTO> getAllPhases() {
//		
//		return phaseService.findAll();
//	}
	
	@GetMapping("/phases")
	public ResponseEntity<List<PhaseDTO>> getAllPhases() {
		List<PhaseDTO> listPhaseDTO = phaseService.findAll();
		if (listPhaseDTO.isEmpty()) {
			
			return new ResponseEntity<List<PhaseDTO>>(HttpStatus.NO_CONTENT);
		}
			
		return new ResponseEntity<List<PhaseDTO>>(listPhaseDTO, HttpStatus.OK);
	}
	
	/* getById */
	
	@GetMapping("/phase/{id}")
	public PhaseDTO getById(@PathVariable("id") Long id) {
		
		return phaseService.findById(id);
		
	}
	
	/* create */
	
//	@PostMapping("/phase")
//	public PhaseDTO create(@RequestBody PhaseDTO phaseDTO) {
//		
//		return phaseService.save(phaseDTO);
//	}
	
	@PostMapping("/phase")
	public ResponseEntity<PhaseDTO> createPhase(@RequestBody PhaseDTO phaseDTO){
		try {
			phaseService.save(phaseDTO);
			
			return new ResponseEntity<PhaseDTO>(phaseDTO, HttpStatus.CREATED);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<PhaseDTO>(HttpStatus.FOUND);
		}
	}
	
	/* update */
	
	@PutMapping("/phase/{id}")
	public PhaseDTO updatePhase(@RequestBody PhaseDTO phaseDTO, @PathVariable Long id) {
		
		return phaseService.save(phaseDTO);
	}
	
	/* delete */
	
//	@DeleteMapping("/phase/{id}")
//	public void deletePhase(@PathVariable Long id) {
//		phaseService.delete(id);
//	}
	
	@DeleteMapping("/phase/{id}")
	public ResponseEntity<Void> deletePhase(@PathVariable Long id) {
		phaseService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
