package com.bmu.pronostics.repository;

import com.bmu.pronostics.domain.Stade;
import com.bmu.pronostics.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

     Page<Stade> findAll(Pageable pageable);
   
}