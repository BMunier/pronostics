package com.bmu.pronostics.service;

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
    
    public TeamsService(){

    }
}