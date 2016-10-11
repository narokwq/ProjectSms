package com.br.services;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ProfessorDAO;
import com.br.model.Login;
import com.br.model.Professor;

@Service
@Transactional
public class ProfessorService {

	@Autowired
	ProfessorDAO professorDAO;

	public void criar(Professor professor) throws Exception {
		boolean exist = professorDAO.exist(professor);
		if(exist){
			throw new Exception("Usuario já existe");
		}	
		professorDAO.insert(professor);

	}
	

	public void remover(Professor professor) {
		professorDAO.delete(professor);
	}

	public void atualizar(Professor professor) {
		professorDAO.update(professor);
	}


	public Professor procurar(Professor professor) {
		Professor result = null;
		result = professorDAO.findById(professor.getId());

		return result;
	}

	public List<Professor> listar() {
		List<Professor> result = Collections.emptyList();
		result = professorDAO.getAll();

		return result;
	}
	
	public Professor procurarPorLoginSenha(Login login) {
		Professor result = null;
		result = professorDAO.procurarLoginSenha(login);
		
		return result;
	}
	

	public Professor logar(Login login){
		try {
			login.criarSenha(login.getSenha());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return procurarPorLoginSenha(login);
	}
}
