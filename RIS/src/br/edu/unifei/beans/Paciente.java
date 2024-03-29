package br.edu.unifei.beans;

// Generated 30/10/2008 01:01:30 by Hibernate Tools 3.2.2.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Paciente generated by hbm2java
 */
public class Paciente implements java.io.Serializable {

	private String codPaciente;
	private String nomPaciente;
	private String sbnPaciente;
	private Integer idfCor;
	private String idfSexo;
	private Date dtaNascimento;
	private Set<ExameRadiologico> exameRadiologicos = new HashSet<ExameRadiologico>(
			0);

	public Paciente() {
	}

	public Paciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}

	public Paciente(String codPaciente, String nomPaciente, String sbnPaciente,
			Integer idfCor, String idfSexo, Date dtaNascimento,
			Set<ExameRadiologico> exameRadiologicos) {
		this.codPaciente = codPaciente;
		this.nomPaciente = nomPaciente;
		this.sbnPaciente = sbnPaciente;
		this.idfCor = idfCor;
		this.idfSexo = idfSexo;
		this.dtaNascimento = dtaNascimento;
		this.exameRadiologicos = exameRadiologicos;
	}

	public String getCodPaciente() {
		return this.codPaciente;
	}

	public void setCodPaciente(String codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getNomPaciente() {
		return this.nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}

	public String getSbnPaciente() {
		return this.sbnPaciente;
	}

	public void setSbnPaciente(String sbnPaciente) {
		this.sbnPaciente = sbnPaciente;
	}

	public Integer getIdfCor() {
		return this.idfCor;
	}

	public void setIdfCor(Integer idfCor) {
		this.idfCor = idfCor;
	}

	public String getIdfSexo() {
		return this.idfSexo;
	}

	public void setIdfSexo(String idfSexo) {
		this.idfSexo = idfSexo;
	}

	public Date getDtaNascimento() {
		return this.dtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public Set<ExameRadiologico> getExameRadiologicos() {
		return this.exameRadiologicos;
	}

	public void setExameRadiologicos(Set<ExameRadiologico> exameRadiologicos) {
		this.exameRadiologicos = exameRadiologicos;
	}

}
