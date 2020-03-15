package br.com.temspotify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.temspotify.controller.MyPlaylistServlet;

public class DataSource {
	private String host;
	private String dataBase;
	private String user;
	private String password;
	private Connection connection;

	public DataSource() {
	  try {
	  //DriverManager.registerDriver(new com.mysql.jdbc.Driver);
	  host     = "127.0.0.1";
	  dataBase = "temspotify";
	  user     = "postgres";
	  password = "ab1530";
	  String URL = "jdbc:postgresql://"+host+"/"+dataBase;
	    this.connection = DriverManager.getConnection(URL, user, password); 
	  }
	  catch(SQLException ex) {
		  System.out.println("ERRO ao conectar: "+ex.getMessage());
	  }
  }
	
  public Connection getConnection() {
	  return this.connection;
  }

}
