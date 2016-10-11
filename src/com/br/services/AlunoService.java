package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.AlunoDAO;
import com.br.model.Aluno;

@Service
@Transactional
public class AlunoService {

	@Autowired
	AlunoDAO alunoDAO;

	public void criar(Aluno aluno) throws Exception {
		if(aluno.gatParticipacaos() == null){
			throw new Exception("Cardapio sem categoria");
		}
		alunoDAO.insert(aluno);

	}

	public void remover(Aluno aluno) {
		alunoDAO.delete(aluno);
	}

	public void atualizar(Aluno aluno) {
		alunoDAO.update(aluno);
	}


	public Aluno procurar(Aluno aluno) {
		Aluno result = null;
		result = alunoDAO.findById(aluno.getId());

		return result;
	}

	public List<Aluno> listar() {
		List<Aluno> result = Collections.emptyList();
		result = alunoDAO.getAll();

		return result;
	}
}
