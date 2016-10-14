package com.br.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "tb_sala")
public class Sala implements EntityClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Professor professor;
	@OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Participacao> participacaos;
	private String key;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Participacao> getParticipacaos() {
		return participacaos;
	}

	public void setParticipacaos(List<Participacao> participacaos) {
		this.participacaos = participacaos;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getSizeParticipacoes() {
		int valor = 0;
		if (participacaos != null) {
			valor = participacaos.size();
		}
		return valor;
	}

}
