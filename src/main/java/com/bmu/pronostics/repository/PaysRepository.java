package com.bmu.pronostics.repository;

import com.bmu.pronostics.domain.Pays;
import com.bmu.pronostics.service.dto.PaysDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Pays entity.
 */
@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

    Page<Pays> findAll(Pageable pageable);

    Optional<Pays> findOneByNom(String nom);

    Optional<Pays> findOneByCode(String code);
}
