package br.com.temspotify.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.temspotify.dao.DataSource;
import br.com.temspotify.dao.UsuarioDAO;
import br.com.temspotify.model.Usuario;

public class EfetivarCadastroServlet extends HttpServlet{
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   String pagina = "/myaccount.jsp";
	   
	   String nome  = req.getParameter("txtNome");
	   String email = req.getParameter("txtEmail");
	   String senha = req.getParameter("txtSenha");
	   Usuario usuario = new Usuario();
	   usuario.setNome(nome);
	   usuario.setEmail(email);
	   usuario.setSenha(senha);
	   DataSource dataSource = new DataSource();
	   UsuarioDAO dao = new UsuarioDAO(dataSource);
	   dao.create(usuario);
	   System.out.println(usuario);
	   
	   try {
		   req.getSession().setAttribute("Usuario", usuario);
		   dataSource.getConnection().close();
		   
	   }
	   catch(Exception ex){
		    pagina = "/erro.jsp";
		    req.getSession().setAttribute("erroSTR", "Erro ao fechar a conexão");
		    System.out.println("Erro ao fechar a conexão: "+ex.getMessage());
	   }
	   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
	   dispatcher.forward(req, resp);
   }
}
