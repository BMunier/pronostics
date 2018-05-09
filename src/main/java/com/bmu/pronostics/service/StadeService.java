package com.bmu.pronostics.service;

import java.util.Optional;

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

    public StadeService(StadeRepository stadeRepository, StadeSearchRepository stadeSearchRepository) {
        this.stadeRepository = stadeRepository;
        this.stadeSearchRepository = stadeSearchRepository;
    }

    @Transactional(readOnly = true)
    public Page<StadeDTO> getAllStades(Pageable pageable) {
        return stadeRepository.findAll(pageable).map(StadeDTO::new);
    }

    @Transactional(readOnly = true)
    public Optional<StadeDTO> getStadeById(Long id) {
        return Optional.of(stadeRepository.findOne(id)).map(StadeDTO::new);
    }

    /**
     * Update all information for a specific stade, and return the modified stade.
     *
     * @param stadeDTO user to update
     * @return updated stade
     */
    public Optional<StadeDTO> updateStade(StadeDTO stadeDTO) {
        return Optional.of(stadeRepository.findOne(stadeDTO.getId())).map(stade -> {
            stade.setId(stadeDTO.getId());
            stade.setNom(stadeDTO.getNom());
            stade.setVille(stadeDTO.getVille());
            stade.setNombrePlaces(stadeDTO.getNombrePlaces());
            stadeSearchRepository.save(stade);
            log.debug("Changed Information for Stade: {}", stade);
            return stade;
        }).map(StadeDTO::new);
    }
}