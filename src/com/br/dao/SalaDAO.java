package com.br.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Sala;

@Repository
public class SalaDAO extends GenericDAO<Sala>{
	
	@Override
	public Class<Sala> getClassType() {
		return Sala.class;
	}

	public boolean check(String key) {
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(s) FROM tb_sala s WHERE s.key = :key");
		result.setParameter("key", key);
		return ((long) result.getSingleResult()) != 0;
	}
}
