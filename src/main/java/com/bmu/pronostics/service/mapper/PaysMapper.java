package com.bmu.pronostics.service.mapper;

import com.bmu.pronostics.domain.Pays;
import com.bmu.pronostics.service.dto.PaysDTO;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper for the entity Pays and its DTO called PaysDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class PaysMapper {

    public PaysDTO PaysToPaysDTO(Pays Pays) {
        return new PaysDTO(Pays);
    }

    public List<PaysDTO> PayssToPaysDTOs(List<Pays> pays) {
        return pays.stream()
            .filter(Objects::nonNull)
            .map(this::PaysToPaysDTO)
            .collect(Collectors.toList());
    }

    public Pays PaysDTOToPays(PaysDTO paysDTO) {
        if (paysDTO == null) {
            return null;
        } else {
            Pays pays = new Pays();
            pays.setId(paysDTO.getId());
            pays.setNom(paysDTO.getNom());
            pays.setCode(paysDTO.getCode());
            pays.setDrapeauUrl(paysDTO.getDrapeauUrl());
            return pays;
        }
    }

    public List<Pays> PaysDTOsToPayss(List<PaysDTO> paysDTO) {
        return paysDTO.stream()
            .filter(Objects::nonNull)
            .map(this::PaysDTOToPays)
            .collect(Collectors.toList());
    }

    public Pays PaysFromId(Long id) {
        if (id == null) {
            return null;
        }
        Pays pays = new Pays();
        pays.setId(id);
        return pays;
    }
}
