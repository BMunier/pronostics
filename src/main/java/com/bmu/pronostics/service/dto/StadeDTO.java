package com.bmu.pronostics.service.dto;

import java.time.Instant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bmu.pronostics.domain.Stade;

import org.hibernate.validator.constraints.NotBlank;

public class StadeDTO{
    private Long id;

   
    @NotNull
    @Size(min = 1, max = 100)
    private String nom;

    @NotNull
    @Size(min = 1, max = 100)
    private String ville;
    
    @NotNull
    private Double nombrePlaces;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    public StadeDTO() {
        // Empty constructor needed for Jackson.
    }

    public StadeDTO(Stade stade) {
        this.id = stade.getId();
        this.nom = stade.getNom();
        this.ville = stade.getVille();
        this.nombrePlaces = stade.getNombrePlaces();
        this.createdBy = stade.getCreatedBy();
        this.createdDate = stade.getCreatedDate();
        this.lastModifiedBy = stade.getLastModifiedBy();
        this.lastModifiedDate = stade.getLastModifiedDate();
     
    }

    @Override
    public String toString() {
        return "StadeDTO{" +
            "nom='" + nom + '\'' +
            ", ville='" + ville + '\'' +
            ", nombrePlaces='" + nombrePlaces + '\'' +
            ", createdBy=" + createdBy +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            "}";
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
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
     * @return the ville
     */
    public String getVille() {
        return ville;
    }
    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    /**
     * @return the nombrePlaces
     */
    public Double getNombrePlaces() {
        return nombrePlaces;
    }
    /**
     * @param nombrePlaces the nombrePlaces to set
     */
    public void setNombrePlaces(Double nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * @return the createdDate
     */
    public Instant getCreatedDate() {
        return createdDate;
    }
    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
    /**
     * @return the lastModifiedBy
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    /**
     * @return the lastModifiedDate
     */
    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

}