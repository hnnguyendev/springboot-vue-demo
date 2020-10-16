package com.backendphase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendphase.entity.PhaseEntity;

public interface IPhaseRepository extends JpaRepository<PhaseEntity, Long> {

}
