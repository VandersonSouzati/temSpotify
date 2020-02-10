package br.com.temspotify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.temspotify.dao.UsuarioDao;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String pagina;
		List<Object> usuarios;
		UsuarioDao userDao = new UsuarioDao();
		usuarios = userDao.read(null);

		if (email.equals("avam200@hotmail.com") && senha.equals("1234")) {
			request.getSession().setAttribute("Usuario", usuarios.get(0));
			pagina = "/myaccount.jsp";

		} else {
			request.setAttribute("erroSTR", "Error Login ou Senha errado");
			pagina = "/error.jsp";
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
