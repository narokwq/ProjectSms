package com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ParticipacaoDAO;
<<<<<<< HEAD
=======
import com.br.model.Aluno;
>>>>>>> 5ecb315c1fc2af8e55a433e1f596085a5b0dfdf4
import com.br.model.Participacao;

@Service
@Transactional
public class ParticipacaoService {
	@Autowired
	ParticipacaoDAO participacaoDAO;
	
	public void removerParticipacao(Participacao participacao) {
		participacaoDAO.delete(participacao);
	}
<<<<<<< HEAD
=======
	
>>>>>>> 5ecb315c1fc2af8e55a433e1f596085a5b0dfdf4
	public Participacao procurar(Participacao participacao) {
		Participacao result = null;
		result = participacaoDAO.findById(participacao.getId());
		return result;
	}
	
<<<<<<< HEAD
	
=======
	public void atulizarPontuacao(Participacao participacao) {
		Participacao result = procurar(participacao);
		result.addPonto(10);
		if(result != null)
			participacaoDAO.update(result);
	}
>>>>>>> 5ecb315c1fc2af8e55a433e1f596085a5b0dfdf4
}
