package br.com.temspotify.dao;

import java.util.List;
import java.util.ArrayList;

import br.com.temspotify.model.Usuario;
import br.com.temspotify.model.Playlist;
import br.com.temspotify.model.Musica;
public class UsuarioDao implements GenericDao{
	public void create(Object o) {

	}

	public List<Object> read(Object o) {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setEmail("vanderson@teste.com");
		usuario.setNome("Vanderson");
		usuario.setSenha("1234");
		ArrayList<Playlist> listaPlayList = new ArrayList<Playlist>();
		Playlist playlist = new Playlist();
		playlist.setId(1);
		playlist.setTitulo("crassicos do roque");
		
		ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
		Musica musica = new Musica();
		musica.setId(1);
        musica.setTitulo("Titulo da musica 1");
        musica.setArtista("Zé da padaria");
        musica.setAlbum("O pão de forma");
        musica.setEstilo(1);
        musica.setLinkMP3("\\\\servidor\\musicas\\musica1.mp4");
        listaMusicas.add(musica);
        
        playlist.setMusicas(listaMusicas);
        listaPlayList.add(playlist);
        usuario.setPlayLists(listaPlayList);
        ArrayList<Object> resultado = new ArrayList<Object>();
        resultado.add(usuario);
		return resultado;
	}

	public void update(Object o) {

	}

	public void delete(Object o) {

	}
}
