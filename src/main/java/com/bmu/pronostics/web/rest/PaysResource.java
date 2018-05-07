package com.bmu.pronostics.web.rest;

import com.bmu.pronostics.repository.PaysRepository;
import com.bmu.pronostics.service.PaysService;
import com.bmu.pronostics.service.dto.PaysDTO;
import com.bmu.pronostics.web.rest.util.PaginationUtil;
import com.bmu.pronostics.web.rest.vm.LoggerVM;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/pays")
public class PaysResource {
    
    private final Logger log = LoggerFactory.getLogger(PaysResource.class);

    private final PaysService paysService;
    private final PaysRepository paysRepository;

    public PaysResource(PaysService paysService, PaysRepository paysRepository){
        this.paysService = paysService;
        this.paysRepository = paysRepository;
    }

    /**
     * GET /tous : get all pays.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all pays
     */
    @GetMapping("/tous")
    @Timed
    public ResponseEntity<List<PaysDTO>> getAllPays(Pageable pageable) {
        final Page<PaysDTO> page = paysService.getAllPays(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/pays/tous");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
