package com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ParticipacaoDAO;


import com.br.model.Aluno;
import com.br.model.Participacao;

@Service
@Transactional
public class ParticipacaoService {
	@Autowired
	ParticipacaoDAO participacaoDAO;
	
	public void removerParticipacao(Participacao participacao) {
		participacaoDAO.delete(participacao);
	}

	public Participacao procurar(Participacao participacao) {
		Participacao result = null;
		result = participacaoDAO.findById(participacao.getId());
		return result;
	}
	
	public void atualizarPontuacao(Participacao participacao) {
		Participacao result = procurar(participacao);
		result.addPonto(10);
		if(result != null)
			participacaoDAO.update(result);
	}
}
