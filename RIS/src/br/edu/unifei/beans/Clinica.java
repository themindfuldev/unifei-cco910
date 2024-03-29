package br.edu.unifei.beans;

// Generated 30/10/2008 01:01:30 by Hibernate Tools 3.2.2.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Clinica generated by hbm2java
 */
public class Clinica implements java.io.Serializable {

	private Integer codClinica;
	private String nomClinica;
	private String codClinicaProdesp;
	private Set<ExameRadiologico> exameRadiologicos = new HashSet<ExameRadiologico>(
			0);

	public Clinica() {
	}

	public Clinica(String nomClinica, String codClinicaProdesp,
			Set<ExameRadiologico> exameRadiologicos) {
		this.nomClinica = nomClinica;
		this.codClinicaProdesp = codClinicaProdesp;
		this.exameRadiologicos = exameRadiologicos;
	}

	public Integer getCodClinica() {
		return this.codClinica;
	}

	public void setCodClinica(Integer codClinica) {
		this.codClinica = codClinica;
	}

	public String getNomClinica() {
		return this.nomClinica;
	}

	public void setNomClinica(String nomClinica) {
		this.nomClinica = nomClinica;
	}

	public String getCodClinicaProdesp() {
		return this.codClinicaProdesp;
	}

	public void setCodClinicaProdesp(String codClinicaProdesp) {
		this.codClinicaProdesp = codClinicaProdesp;
	}

	public Set<ExameRadiologico> getExameRadiologicos() {
		return this.exameRadiologicos;
	}

	public void setExameRadiologicos(Set<ExameRadiologico> exameRadiologicos) {
		this.exameRadiologicos = exameRadiologicos;
	}

}
