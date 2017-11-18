package config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

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
		File arquivo = new File(this.arquivo);
		LogAtividades log = new LogAtividades();
		
		Boolean flag = false;
		
		if (arquivo.exists()) {
			flag = true;
		}else {
			log.setAtividades("SQLite", "Notificacao", "Banco de Dados nao existe, Primeiro uso do Sistema, um banco de dados sera criado.");
		}
		
		try {
			
			Class.forName(this.driveSQLite);
			conexao = DriverManager.getConnection("jdbc:sqlite:"+this.pasta+"\\"+this.arquivo);
			
			
		}catch(Exception e) {
			log.setAtividades("SQLite", "ERRO", e.getMessage());
		}

		
		
		
		
		

		
		
	}
	

}
