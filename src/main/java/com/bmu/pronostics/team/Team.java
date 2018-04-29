package com.bmu.pronostics.team;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "TEAM", schema = "TEAMDB")
public class Team{
    private Integer id;
    private String nomEquipe;
    private String codePays;
    private String rangFifa;

	

public Team (String nomEquipe, String code, String  rang){
   this.nomEquipe = nomEquipe;
   this.codePays = code;
   this.rangFifa = rang;

}
    // Property accessors
    @Id
    @Column(name = "ID")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "NOM")
    public String getNomequipe()
	{
		return this.nomEquipe;
	}

	public void setNomequipe(String nomEquipe)
	{
		this.nomEquipe = nomEquipe;
	}
    @Column(name = "CODEPAYS", length = 3)
	public String getCodepays()
	{
		return this.codePays;
	}

	public void setCodepays(String codePays)
	{
		this.codePays = codePays;
	}
    @Column(name = "RANGFIFA")
	public String getRangfifa()
	{
		return this.rangFifa;
	}

	public void setRangfifa(String rangFifa)
	{
		this.rangFifa = rangFifa;
	}



}