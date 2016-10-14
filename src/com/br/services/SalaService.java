package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.SalaDAO;
import com.br.model.Sala;

@Service
@Transactional
public class SalaService {

	@Autowired
	SalaDAO salaDAO;

	public void criar(Sala sala) throws Exception {
		salaDAO.insert(sala);

	}

	public void remover(Sala sala) {
		salaDAO.delete(sala);
	}

	public void atualizar(Sala sala) {
		salaDAO.update(sala);
	}

	public Sala procurar(Sala sala) {
		Sala result = null;
		result = salaDAO.findById(sala.getId());

		return result;
	}

	public Sala procurarByKey(String keyhash) {
		Sala result = null;
		result = salaDAO.findByKey(keyhash);

		return result;
	}

	public List<Sala> listar() {
		List<Sala> result = Collections.emptyList();
		result = salaDAO.getAll();

		return result;
	}

	public boolean checkKey(String key) {
		return salaDAO.check(key);
	}
}
