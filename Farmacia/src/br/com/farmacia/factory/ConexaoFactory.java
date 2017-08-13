package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String USUARIO ="postgres";
	private static final String SENHA ="root";
	
	private static final String URL ="jdbc:postgresql://localhost:5432/farmacia";
	
	
	
	public static Connection conectar() throws SQLException{
		try {
			
		Class.forName("org.postgresql.Driver");

		} catch (Exception e) {
		System.out.println("Falha com Driver do banco");
		}
		Connection connection = DriverManager.getConnection(URL,USUARIO,SENHA);
		
		return connection;
	}
	public static void main(String[] args) {
		try {
			
			@SuppressWarnings("unused")
			Connection connection = ConexaoFactory.conectar();
			
		} catch (SQLException e) {
		System.out.println("Falha na comunicação, entrar em contato com o desenvolvedor. " + e.getLocalizedMessage());
			//e.printStackTrace();
		}
	}
	
}
