package com.br.model;

public class Sorteado {
	public Long id;
	public String nome;
	public int pontuacao;
	
	public Sorteado() {
	}
	
	public Sorteado(Long id, String nome, int pontuacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
