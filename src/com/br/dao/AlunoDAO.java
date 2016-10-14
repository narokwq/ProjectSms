package com.br.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Aluno;

@Repository
public class AlunoDAO extends GenericDAO<Aluno> {

	@Override
	public Class<Aluno> getClassType() {
		return Aluno.class;
	}

	public boolean check(String telefone) {
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(a) FROM tb_aluno a WHERE a.telefone = :telefone");
		result.setParameter("telefone", telefone);
		return ((long) result.getSingleResult()) != 0;
	}

	public boolean check(String telefone, String keyhash) {
		Query result = null;
		result = this.manager.createQuery(
				"SELECT COUNT(a) FROM tb_aluno a JOIN a.participacaos p WHERE a.telefone = :telefone AND p.sala.key = :key");
		result.setParameter("telefone", telefone);
		result.setParameter("key", keyhash);

		return ((long) result.getSingleResult()) != 0;
	}
}
