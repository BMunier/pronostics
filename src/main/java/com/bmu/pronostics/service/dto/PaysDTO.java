package com.bmu.pronostics.service.dto;

import com.bmu.pronostics.domain.Pays;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

/**
 * A DTO representing a user, with his authorities.
 */
public class PaysDTO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String nom;

    @NotBlank
    @Size(max = 3)
    private String code;

    @Size(max = 256)
    private String drapeauUrl;

    public PaysDTO() {
        // Empty constructor needed for Jackson.
    }

    public PaysDTO(Pays pays) {
        this.id = pays.getId();
        this.nom = pays.getNom();
        this.code = pays.getCode();
        this.drapeauUrl = pays.getDrapeauUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @return the drapeauUrl
     */
    public String getDrapeauUrl() {
        return drapeauUrl;
    }
    /**
     * @param drapeauUrl the drapeauUrl to set
     */
    public void setDrapeauUrl(String drapeauUrl) {
        this.drapeauUrl = drapeauUrl;
    }
}
