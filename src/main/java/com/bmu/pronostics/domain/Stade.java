package com.bmu.pronostics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "pro_stade")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "stade")
public class Stade extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, unique = true, nullable = false)
    private String nom;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String ville;
    
    @NotNull
    @Column(nullable=false)
    private Double nombrePlaces;
    
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
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
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
     * @return the nombre_places
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
}