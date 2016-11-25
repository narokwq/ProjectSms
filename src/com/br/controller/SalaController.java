package com.br.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.model.Grupo;
import com.br.model.Participacao;
import com.br.model.Professor;
import com.br.model.Sala;
import com.br.model.Sorteado;
import com.br.services.SalaService;
import com.br.util.HashPassword;
import com.br.util.SMS;

@RequestMapping("sala")
@Controller
public class SalaController {
	@Autowired
	private SalaService salaService;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(ModelMap map) {
		map.addAttribute("sala", new Sala());
		return "form_sala";
	}

	@RequestMapping(method = RequestMethod.POST, value = "salvar")
	public String salvar(@Valid @ModelAttribute("sala") Sala sala, BindingResult result, HttpSession session)
			throws Exception {
		if (result.hasErrors()) {
			return "erro";
		}
		Professor professor = (Professor) session.getAttribute("usuario");
		if (professor.hasValidId()) {
			String keyHash = HashPassword.uniqueLink();
			while (salaService.checkKey(keyHash))
				;
			sala.setKey(keyHash);
			sala.setProfessor(professor);
			salaService.criar(sala);
		} else {
			return "redirect:/login";
		}
		return "redirect:/home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/list")
	public String updateForm(@PathVariable String keyhash, ModelMap map) {
		Sala sala = salaService.procurarByKey(keyhash);
		if(sala != null){
			Collections.sort(sala.getParticipacaos());
			map.addAttribute("sala", sala);
			map.addAttribute("keyhash", keyhash);
			return "sala";
		}
		return "redirect:/home";
		
	}
	/////////////////////// Guga
	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/remover")
	public String remover(@PathVariable String keyhash){
		Sala sala = salaService.procurarByKey(keyhash);
		System.out.println("entrou remover");
		if(sala!= null){
			salaService.remover(sala);
		}
		return "redirect:/home";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "{keyhash}/selecao", produces = "application/json")
	public @ResponseBody List<Sorteado> selecao(@PathVariable String keyhash, @RequestParam(value="myArray[]") List<Long> myArray, @RequestParam(value="qnt") int qnt){
		Sala sala = salaService.procurarByKey(keyhash);
		List<Sorteado> sorteados = new ArrayList<>();
		List<String> numeroEscolhidos = new ArrayList<>();
		
		for (; 0 < qnt; qnt--) {
			Random rand = new Random();
			int numero = rand.nextInt(qnt+1);
			
			for (Participacao part : sala.getParticipacaos()) {
				if(myArray.get(numero) == part.getAluno().getId()){
					System.out.println(part.getAluno().getTelefone());
					numeroEscolhidos.add(SMS.format(part.getAluno().getTelefone()));
					sorteados.add(new Sorteado(part.getAluno().getId(), part.getAluno().getNome(), part.getPontuacao()));		
					myArray.remove(numero);
					break;
				}
				
			}
		}
		
		SMS.enviarLocasms(String.join(",", numeroEscolhidos), "Você foi escolhido!");
 
		return sorteados;
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "{keyhash}/selecao", produces = "application/json")
	public @ResponseBody List<Sorteado> selecao(@PathVariable String keyhash, @RequestParam(value="myArray[]") List<Long> myArray, @RequestParam(value="qnt") int qnt){
		Sala sala = salaService.procurarByKey(keyhash);
		List<Sorteado> sorteados = new ArrayList<>();
		
		for (; 0 < qnt; qnt--) {
			Random rand = new Random();
			int numero = rand.nextInt(qnt);
			
			for (Participacao part : sala.getParticipacaos()) {
				if(myArray.get(numero) == part.getAluno().getId()){
					System.out.println(part.getAluno().getTelefone());
					SMS.enviarSms(part.getAluno().getTelefone());
					sorteados.add(new Sorteado(part.getAluno().getId(), part.getAluno().getNome(), part.getPontuacao()));		
					myArray.remove(numero);
					break;
				}
				
			}
		}	
 
		return sorteados;
	}*/
	
	
	@RequestMapping(method = RequestMethod.POST, value = "{keyhash}/grupo", produces = "application/json")
	public @ResponseBody List<Grupo> grupo(@PathVariable String keyhash, @RequestParam(value="myArray[]") List<Long> myArray, @RequestParam(value="qnt") int qnt){
		Sala sala = salaService.procurarByKey(keyhash);
		Random rand = new Random();
		List<Grupo> grupo = new ArrayList<>();
		if(myArray.isEmpty()){
			for (Participacao part : sala.getParticipacaos()) {
				myArray.add(part.getAluno().getId());
			}
		}
		int sortqnt = myArray.size();
		int quantidadeAlunos = myArray.size() / qnt;
		System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println(myArray);
		
		for (int i = 0; i < qnt; i++) {
			String nomeGrupo = "Grupo "+i;
			List<String> numeroEscolhidos = new ArrayList<>();
			for (int j = 0; j < quantidadeAlunos; j++) {
				
				int numero = rand.nextInt(sortqnt);
				for (Participacao part : sala.getParticipacaos()) {
					if(myArray.get(numero) == part.getAluno().getId()){
						numeroEscolhidos.add(SMS.format(part.getAluno().getTelefone()));
						grupo.add(new Grupo(nomeGrupo, part.getAluno().getNome()));
						myArray.remove(numero);
						break;
					}
				}
				sortqnt--;
				if(myArray.isEmpty())
					break;
			}
			SMS.enviarLocasms(String.join(",", numeroEscolhidos), nomeGrupo);
		}
		for(Long aluno:myArray){
			for (Participacao part : sala.getParticipacaos()) {
				if(aluno == part.getAluno().getId()){
					grupo.add(new Grupo("Grupo X", part.getAluno().getNome()));
					break;
				}
			}
		}
		return grupo;
	}
}
