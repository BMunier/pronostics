package com.bmu.pronostics.service;
import javax.transaction.Transactional;

import com.bmu.pronostics.repository.PaysRepository;
import com.bmu.pronostics.service.dto.PaysDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class PaysService {
    
    private final Logger log = LoggerFactory.getLogger(PaysService.class);
    
    private final PaysRepository paysRepository;

    public PaysService(PaysRepository paysRepository){
        this.paysRepository = paysRepository;
    }

    public Page<PaysDTO> getAllPays(Pageable pageable) {
        return paysRepository.findAll(pageable).map(PaysDTO::new); 
    }
}