package com.bmu.pronostics.service;

import com.bmu.pronostics.repository.StadeRepository;
import com.bmu.pronostics.repository.search.StadeSearchRepository;
import com.bmu.pronostics.service.dto.StadeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StadeService {

    private final Logger log = LoggerFactory.getLogger(StadeService.class);

    private final StadeRepository stadeRepository;

    private final StadeSearchRepository stadeSearchRepository;

    public StadeService(StadeRepository stadeRepository, StadeSearchRepository stadeSearchRepository){
        this.stadeRepository = stadeRepository;
        this.stadeSearchRepository = stadeSearchRepository;
    }

    @Transactional(readOnly = true)
    public Page<StadeDTO> getAllStades(Pageable pageable) {
        return stadeRepository.findAll(pageable).map(StadeDTO::new);
    }

}