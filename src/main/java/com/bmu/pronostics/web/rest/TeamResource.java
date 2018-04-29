package com.bmu.pronostics.web.rest;

import com.bmu.pronostics.service.TeamsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for getting the teams
 */
@RestController
@RequestMapping("/management/teams")
public class TeamResource{

    private final TeamsService teamsService;

    public TeamResource(TeamsService teamService){
        this.teamsService = teamService;
    }
}