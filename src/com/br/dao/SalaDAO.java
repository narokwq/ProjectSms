package com.br.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Sala;

@Repository
public class SalaDAO extends GenericDAO<Sala> {

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

	public Sala findByKey(String key) {
		Query query = manager.createQuery("SELECT s FROM tb_sala s WHERE s.key = :key");
		query.setParameter("key", key);

		List<?> sala = query.getResultList();

		return sala.isEmpty() ? null : (Sala) sala.get(0);
	}
}
