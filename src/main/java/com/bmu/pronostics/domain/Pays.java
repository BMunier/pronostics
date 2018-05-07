package com.bmu.pronostics.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Un pays.
 */
@Entity
@Table(name = "jhi_pays")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "pays")
public class Pays extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nom", length = 50, unique = true)
    private String nom;

    @NotNull
    @Size(max = 3)
    @Column(name = "code", length = 3, unique = true)
    private String code;

    @Size(max = 256)
    @Column(name = "drapeau_url", length = 256)
    private String drapeauUrl;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getDrapeauUrl(){
        return drapeauUrl;
    }

    public void setDrapeauUrl(String drapeauUrl){
        this.drapeauUrl = drapeauUrl;
    }
}