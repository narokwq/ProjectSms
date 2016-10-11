package com.br.dao;

import org.springframework.stereotype.Repository;

import com.br.model.Aluno;

@Repository
public class AlunoDAO extends GenericDAO<Aluno>{
	
	@Override
	public Class<Aluno> getClassType() {
		return Aluno.class;
	}
}
