package com.br.model;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="tb_professor")
public class Professor implements EntityClass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Embedded
	private Login login;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date data;
	@OneToMany(mappedBy="professor", fetch=FetchType.EAGER)
	private List<Sala> salas;
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public void addSalas(Sala sala) {
		this.salas.add(sala);
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void createLogin(String user, String senha) throws NoSuchAlgorithmException{
		login = new Login();
		login.setLogin(user);
		login.criarSenha(senha);
	}
	
	public boolean hasValidId() {
		return getId() != null && getId() != 0;
	}
}
