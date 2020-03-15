package br.com.temspotify.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.temspotify.dao.DataSource;
import br.com.temspotify.dao.UsuarioDAO;
import br.com.temspotify.model.Usuario;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		System.out.println(usuario.getEmail() + "--"+usuario.getSenha());
		List<Object> res;
		String pagina = "/error.jsp";
		try {
			DataSource dataSource = new DataSource();
			UsuarioDAO userDao = new UsuarioDAO(dataSource);
			res = userDao.read(usuario);

			if (res != null && res.size() > 0) {
				pagina = "/myaccount.jsp";
				request.getSession().setAttribute("Usuario", res.get(0));
			} else {
				request.getSession().setAttribute("erroSTR", "Error Usuário / Senha invalido");
			}
			dataSource.getConnection().close();
		} catch (SQLException ex) {
			request.getSession().setAttribute("erroSTR", "Error SQL");
		}

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
		/*
		 * if (email.equals("avam200@hotmail.com") && senha.equals("1234")) {
		 * request.getSession().setAttribute("Usuario", usuarios.get(0)); pagina =
		 * "/myaccount.jsp";
		 * 
		 * } else { request.setAttribute("erroSTR", "Error Login ou Senha errado");
		 * pagina = "/error.jsp"; }
		 */
	}
}
