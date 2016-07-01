package com.algaworks.brewer.model;

import java.util.Date;

public class Usuario {
	
	private long id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private String senha;
	private String confirmaSenha;
	private Status status;
	private Grupos grupos;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Grupos getGrupos() {
		return grupos;
	}
	public void setGrupos(Grupos grupos) {
		this.grupos = grupos;
	}
	
	
	

}
