package com.br.dao;

import org.springframework.stereotype.Repository;

import com.br.model.Sala;

@Repository
public class SalaDAO extends GenericDAO<Sala>{
	
	@Override
	public Class<Sala> getClassType() {
		return Sala.class;
	}
}
