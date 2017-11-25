package config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import log.LogAtividades;

public class SQLite {
	
	
	private static String driveSQLite;
	private static String arquivo;
	private static String pasta;
	private static Connection conexao;

	
	
	
	public SQLite(){


				this.driveSQLite = "org.sqlite.JDBC";
				this.pasta = "DataBase";
				this.arquivo = "tests.db";
		
				conexao = null;

				File pastas;
		
				File arquivo;
				LogAtividades log = new LogAtividades();

		
				Boolean flag = false;
			
				try {
			
				pastas = new File(this.pasta);
				pastas.mkdirs();
		
				arquivo = new File(this.pasta+"\\"+this.arquivo);
		
				if (arquivo.exists()) {
					flag = true;
				}else {
					log.setAtividades("SQLite", "Notificacao", "Banco de Dados nao existe, Primeiro uso do Sistema, um banco de dados sera criado.");
				}
		
					
			Class.forName(this.driveSQLite);
			conexao = DriverManager.getConnection("jdbc:sqlite:"+this.pasta+"\\"+this.arquivo);
			
			
		}catch(Exception e) {
			log.setAtividades("SQLite", "ERRO", e.getMessage());
		}



		
		if(flag!=true) {
		
		try {

			Statement enviar;
			ResultSet resultado;

			enviar = conexao.createStatement();
			resultado = enviar.executeQuery("CREATE TABLE testando(int id)");

			conexao.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.setAtividades("SQLite", "Resultado do Query", e.getMessage());
		}
		
		}
		

		
		
	}
	

}
