package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.AlunoDAO;
import com.br.dao.ParticipacaoDAO;
import com.br.model.Aluno;
import com.br.model.Participacao;

@Service
@Transactional
public class AlunoService {

	@Autowired
	AlunoDAO alunoDAO;
	@Autowired
	ParticipacaoDAO participacaoDAO;

	public void criar(Aluno aluno) throws Exception {
		if (aluno.gatParticipacaos() == null) {
			throw new Exception("Aluno sem Sala");
		}
		alunoDAO.insert(aluno);

	}

	public void criarParticipacao(Participacao participacao) throws Exception {
		if (participacao.getAluno() == null) {
			throw new Exception("Aluno sem Sala");
		}
		participacaoDAO.insert(participacao);

	}

	public void remover(Aluno aluno) {
		alunoDAO.delete(aluno);
	}

	public void removerParticipacao(Participacao participacao) {
		participacaoDAO.delete(participacao);
	}

	public void atualizar(Aluno aluno) {
		alunoDAO.update(aluno);
	}

	public Aluno procurar(Aluno aluno) {
		Aluno result = null;
		result = alunoDAO.findById(aluno.getId());

		return result;
	}

	public boolean procurarByTelefone(Aluno aluno) {

		return alunoDAO.check(aluno.getTelefone());
	}

	public boolean procurarByTelefoneAndKey(Aluno aluno, String keyhash) {

		return alunoDAO.check(aluno.getTelefone(), keyhash);
	}

	public List<Aluno> listar() {
		List<Aluno> result = Collections.emptyList();
		result = alunoDAO.getAll();

		return result;
	}
}
