package com.bmu.pronostics.service.mapper;

import com.bmu.pronostics.domain.Authority;
import com.bmu.pronostics.domain.Stade;
import com.bmu.pronostics.domain.User;
import com.bmu.pronostics.service.dto.StadeDTO;
import com.bmu.pronostics.service.dto.UserDTO;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class StadeMapper {

    public StadeDTO stadeToStadeDTO(Stade stade) {
        return new StadeDTO(stade);
    }

    public List<StadeDTO> stadesToStadeDTOs(List<Stade> stades) {
        return stades.stream()
            .filter(Objects::nonNull)
            .map(this::stadeToStadeDTO)
            .collect(Collectors.toList());
    }

    public Stade stadeDTOToStade(StadeDTO stadeDTO) {
        if (stadeDTO == null) {
            return null;
        } else {
            Stade stade = new Stade();
            stade.setId(stadeDTO.getId());
            stade.setNom(stadeDTO.getNom());
            stade.setNombrePlaces(stadeDTO.getNombrePlaces());
            stade.setVille(stadeDTO.getVille());      
            return stade;
        }
    }

    public List<Stade> stadeDTOsToStades(List<StadeDTO> stadeDTOs) {
        return stadeDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::stadeDTOToStade)
            .collect(Collectors.toList());
    }

    public Stade stadeFromId(Long id) {
        if (id == null) {
            return null;
        }
        Stade stade = new Stade();
        stade.setId(id);
        return stade;
    }

    public Set<Authority> authoritiesFromStrings(Set<String> strings) {
        return strings.stream().map(string -> {
            Authority auth = new Authority();
            auth.setName(string);
            return auth;
        }).collect(Collectors.toSet());
    }
}
