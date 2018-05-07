package com.bmu.pronostics.service;

import com.bmu.pronostics.domain.Team;
import com.bmu.pronostics.repository.TeamRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for managing teams.
 *
 * This is the default implementation to support SpringBoot Actuator TeamsRepository
 */
@Service
@Transactional
public class TeamsService {

    private final TeamRepository teamRepository;
    
    public TeamsService(TeamRepository teamRepository){

        this.teamRepository = teamRepository;
    }

	public Page<Team> findAll(Pageable pageable) {
		return teamRepository.findAll(pageable);
	}
}