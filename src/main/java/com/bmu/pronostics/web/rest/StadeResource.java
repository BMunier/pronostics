package com.bmu.pronostics.web.rest;

import com.bmu.pronostics.domain.Stade;
import com.bmu.pronostics.domain.User;
import com.bmu.pronostics.repository.StadeRepository;
import com.bmu.pronostics.repository.UserRepository;
import com.bmu.pronostics.repository.search.StadeSearchRepository;
import com.bmu.pronostics.repository.search.UserSearchRepository;
import com.bmu.pronostics.security.AuthoritiesConstants;
import com.bmu.pronostics.service.MailService;
import com.bmu.pronostics.service.StadeService;
import com.bmu.pronostics.service.UserService;
import com.bmu.pronostics.service.dto.StadeDTO;
import com.bmu.pronostics.web.rest.errors.NameAlreadyUsedException;
import com.bmu.pronostics.web.rest.util.HeaderUtil;
import com.bmu.pronostics.web.rest.util.PaginationUtil;
import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import io.github.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

@RestController
@RequestMapping("/api")
public class StadeResource {

    private final Logger log = LoggerFactory.getLogger(StadeResource.class);

  

    private final MailService mailService;

    private final StadeRepository stadeRepository;

    private final StadeService stadeService;

    
    public StadeResource(MailService mailService, StadeRepository stadeSearchRepository, StadeService stadeService) {
        this.stadeRepository = stadeSearchRepository;
        this.mailService = mailService;
        this.stadeService = stadeService;
    }

      /**
     * GET /stades : get all stades.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping("/stades")
    @Timed
    public ResponseEntity<List<StadeDTO>> getAllStades(Pageable pageable) {
        final Page<StadeDTO> page = stadeService.getAllStades(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/stades");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

      /**
     * GET /Stades/:id : get the "id" stade.
     *
     * @param id the id of the stade
     * @return the ResponseEntity with status 200 (OK) and with body the "id" stade, or with status 404 (Not Found)
     */
    @GetMapping("/stades/{id}")
    @Timed
    public ResponseEntity<StadeDTO> getStadeByid(@PathVariable Long id) {
        log.debug("REST stade to get Stade : {}", id);
        Optional<StadeDTO> stadeById = stadeService.getStadeById(id);
		return ResponseUtil.wrapOrNotFound(stadeById);
    }

    /**
     * PUT /stades : Updates an existing User.
     *
     * @param userDTO the user to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated user
     * @throws EmailAlreadyUsedException 400 (Bad Request) if the email is already in use
     * @throws LoginAlreadyUsedException 400 (Bad Request) if the login is already in use
     */
    @PutMapping("/stades")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<StadeDTO> updateUser(@Valid @RequestBody StadeDTO stadeDTO) {
        log.debug("REST request to update Stade : {}", stadeDTO);

        Optional<Stade> existingStade  = stadeRepository.findOneByNom(stadeDTO.getNom());
        if (existingStade.isPresent() && (!existingStade.get().getId().equals(stadeDTO.getId()))) {
            throw new NameAlreadyUsedException();
        }
        Optional<StadeDTO> updatedUser = stadeService.updateStade(stadeDTO);

        return ResponseUtil.wrapOrNotFound(updatedUser,
            HeaderUtil.createAlert("userManagement.updated", stadeDTO.getNom()));
    }
}