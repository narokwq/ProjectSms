package com.br.dao;

import org.springframework.stereotype.Repository;

import com.br.model.Participacao;

@Repository
public class ParticipacaoDAO extends GenericDAO<Participacao> {

	@Override
	public Class<Participacao> getClassType() {
		return Participacao.class;
	}
	
	

}
