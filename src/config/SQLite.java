package config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import log.LogAtividades;

public class SQLite {
	
	
	private static String driveSQLite;
	private static String arquivo;
	private static String pasta;
	private static Connection conexao;
	
	private static String browserDriver;
	private static String driver;
	private static String ambienteTrabalho;

	public SQLite() {
		
	}
	
	
	public SQLite(String browserDriver, String driver, String ambienteTrabalho){


				this.driveSQLite = "org.sqlite.JDBC";
				this.pasta = "config";
				this.arquivo = "Driver.db";
		
				conexao = null;

				File pastas;
		
				File arquivo;
				File isArquivo;
		
				Boolean flag = false;

				arquivo = new File(this.pasta+"\\"+this.arquivo);
				isArquivo = new File(this.pasta+"\\"+this.arquivo);
			
				try {
			
				pastas = new File(this.pasta);
				pastas.mkdirs();
		
		
				if (arquivo.exists()) {
					flag = true;
				}
		
					
			Class.forName(this.driveSQLite);
			conexao = DriverManager.getConnection("jdbc:sqlite:"+this.pasta+"\\"+this.arquivo);
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e,"ERRO", JOptionPane.ERROR_MESSAGE);
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
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e,"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		}
		
		if (isArquivo.exists()) {

			JOptionPane.showMessageDialog(null, "Sistema Configurado com Sucesso!!!","Configuração do Sistema", JOptionPane.INFORMATION_MESSAGE);
			
		}

		
		
	}
	
	public boolean getConfig () {
		

		this.pasta = "config";
		this.arquivo = "Driver.db";

		File isArquivo;

		isArquivo = new File(this.pasta+"\\"+this.arquivo);

		
		return(isArquivo.exists());
	}
	

}
