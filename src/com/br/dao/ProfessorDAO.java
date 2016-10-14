package com.br.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Login;
import com.br.model.Professor;

@Repository
public class ProfessorDAO extends GenericDAO<Professor>{
	
	@Override
	public Class<Professor> getClassType() {
		return Professor.class;
	}

	public boolean exist(Professor professor) {
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(p) FROM tb_professor p WHERE p.login.login = :login");
		result.setParameter("login", professor.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
	
	public Professor procurarLoginSenha(Login login){
		Query query = manager.createQuery("SELECT p FROM tb_professor p WHERE p.login.login = :login and p.login.senha = :senha");
		query.setParameter("login",login.getLogin());
		query.setParameter("senha",login.getSenha());
	
		List<?> professores =  query.getResultList();
		
		return professores.isEmpty() ? null : (Professor) professores.get(0);
}
}
