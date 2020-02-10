package br.com.temspotify.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.temspotify.model.Usuario;

public class MyPlaylistServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario = (Usuario) request.getSession().getAttribute("Usuario");
		String paginaRetorno;
		
		if (usuario == null) {
			paginaRetorno = "/index.html";
		} else {
			paginaRetorno = "/myplaylist.jsp";
		}

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(paginaRetorno);
		dispatcher.forward(request, response);
	}
}
