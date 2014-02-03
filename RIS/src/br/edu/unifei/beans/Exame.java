package br.edu.unifei.beans;

// Generated 30/10/2008 01:01:30 by Hibernate Tools 3.2.2.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Exame generated by hbm2java
 */
public class Exame implements java.io.Serializable {

	private Integer codExame;
	private String nomExame;
	private Set<ExameRadiologico> exameRadiologicos = new HashSet<ExameRadiologico>(
			0);

	public Exame() {
	}

	public Exame(String nomExame, Set<ExameRadiologico> exameRadiologicos) {
		this.nomExame = nomExame;
		this.exameRadiologicos = exameRadiologicos;
	}

	public Integer getCodExame() {
		return this.codExame;
	}

	public void setCodExame(Integer codExame) {
		this.codExame = codExame;
	}

	public String getNomExame() {
		return this.nomExame;
	}

	public void setNomExame(String nomExame) {
		this.nomExame = nomExame;
	}

	public Set<ExameRadiologico> getExameRadiologicos() {
		return this.exameRadiologicos;
	}

	public void setExameRadiologicos(Set<ExameRadiologico> exameRadiologicos) {
		this.exameRadiologicos = exameRadiologicos;
	}

}