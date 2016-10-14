package com.br.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tb_participacao")
public class Participacao implements EntityClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qtdQuestoes;
	private int pontuacao;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Aluno aluno;
	@ManyToOne
	private Sala sala;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public int getQtdQuestoes() {
		return qtdQuestoes;
	}

	public void setQtdQuestoes(int qtdQuestoes) {
		this.qtdQuestoes = qtdQuestoes;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}
