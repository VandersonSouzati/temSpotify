package br.com.temspotify.model;

import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private List<Playlist> playlists;

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

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playLists) {
		this.playlists = playLists;
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

	public String toString() {
		return this.id + " - "+this.getNome() + " --- "+this.getEmail();
	}
}
