package com.bmu.pronostics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "pro_teams")
public class Team implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="pays")
    private String pays;

    @Column(name="rang")
    private Integer rang;

    @Column(name="code")
    private String code;

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public String getPays()
	{
		return this.pays;
	}

	public void setPays(String pays)
	{
		this.pays = pays;
	}

	public Integer getRang()
	{
		return this.rang;
	}

	public void setRang(Integer rang)
	{
		this.rang = rang;
	}

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

    
}