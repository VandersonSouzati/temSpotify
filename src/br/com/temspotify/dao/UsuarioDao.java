package br.com.temspotify.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.temspotify.model.Usuario;
import br.com.temspotify.model.Playlist;
import br.com.temspotify.model.Musica;

public class UsuarioDAO implements GenericDAO {

	private DataSource dataSource;

	public UsuarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Object o) {
		try {
			if (o instanceof Usuario) {
				Usuario usuario = (Usuario) o;
				String sql = "Insert into tbUsuario(nome, email, senha) values(?,?,?)";
				PreparedStatement smt = dataSource.getConnection().prepareStatement(sql);
				smt.setString(1, usuario.getNome());
				smt.setString(2, usuario.getEmail());
				smt.setString(3, usuario.getSenha());
				int retorno = smt.executeUpdate();
				if (retorno != 0) {
					ResultSet res = smt.getGeneratedKeys();
					if(res.next()) {
						usuario.setId(res.getInt(1));
					}
					res.close();
				}
				smt.close();
				System.out.println("Registro inserido com sucesso");
			} else {
				throw new RuntimeException("Objeto invalido");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao inserir dados: " + ex.getMessage() + " " + ex.toString() + " -- "
					+ ex.getStackTrace() + " -- ");
		}
	}

	public List<Object> read(Object objeto) {
		try {
			if (objeto instanceof Usuario) {
				Usuario usuarioIncompleto = (Usuario) objeto;
				String sql = "Select idUsuario, Nome, Email, Senha From tbUsuario" + "   Where Email =? And Senha = ?";
				PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
				stm.setString(1, usuarioIncompleto.getEmail());
				stm.setString(2, usuarioIncompleto.getSenha());
				ResultSet rs = stm.executeQuery();
				ArrayList<Object> result = new ArrayList<>();
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
					result.add(usuario);
				}
				stm.close();
				rs.close();
				return result;
			} else {
				throw new RuntimeException("Invalid Object");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar usuario: " + ex.getMessage());
		}
		return null;
	}

	public void update(Object o) {

	}

	public void delete(Object o) {

	}

	public List<Object> readOld(Object o) {
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
		usuario.setPlaylists(listaPlayList);
		ArrayList<Object> resultado = new ArrayList<Object>();
		resultado.add(usuario);
		return resultado;
	}
}
