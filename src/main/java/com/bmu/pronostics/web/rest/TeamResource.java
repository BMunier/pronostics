package com.bmu.pronostics.web.rest;

import java.util.List;

import com.bmu.pronostics.domain.Team;
import com.bmu.pronostics.service.TeamsService;
import com.bmu.pronostics.web.rest.util.PaginationUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for getting the teams
 */
@RestController
@RequestMapping("/api")
public class TeamResource{

    private final TeamsService teamsService;

    public TeamResource(TeamsService teamService){
        this.teamsService = teamService;
	}
	
	@GetMapping("/teams")
	public ResponseEntity<List<Team>> getAll(Pageable pageable) {
		Page<Team> page = teamsService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/teams");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);

	}
}