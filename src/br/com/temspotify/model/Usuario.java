package br.com.temspotify.model;

import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private List<Playlist> playLists;

	public Usuario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Playlist> getPlayLists() {
		return playLists;
	}

	public void setPlayLists(List<Playlist> playLists) {
		this.playLists = playLists;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
