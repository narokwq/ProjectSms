package com.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="tb_aluno")
public class Aluno implements EntityClass{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String telefone;
	@OneToMany(mappedBy="aluno", fetch=FetchType.EAGER)
	private List<Participacao> participacaos;
	
	@Override
	public void setId(Long id) {
		this.id= id;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Participacao> gatParticipacaos() {
		return participacaos;
	}
	public void setParticipacaos(List<Participacao> participacaos) {
		this.participacaos = participacaos;
	}

	public void addParts(Participacao part) {
		this.participacaos.add(part);
	}
	
	
}
