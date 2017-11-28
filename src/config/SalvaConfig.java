package config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import log.LogAtividades;

public class SalvaConfig {
	
	
	private static final String driveSQLite = "org.sqlite.JDBC";
	private static final String pasta = "config";
	private static final String arquivo = "Driver.db";
	private static Connection conexao;
	
	private static String browserDriver;
	private static String driver;
	private static String ambienteTrabalho;
	
	private static final String pastaCenarios = "Cenarios";
	
	
	
	public SalvaConfig() {

	}

	public SalvaConfig(String browserDriver, String driver, String ambienteTrabalho){
		
				conexao = null;

				File pastas;
		
				File arquivo;
				File isArquivo;
				
				File pCenarios;
		
				Boolean flag = false;

				arquivo = new File(this.pasta+"\\"+this.arquivo);
				isArquivo = new File(this.pasta+"\\"+this.arquivo);
			
				try {
			
				pastas = new File(this.pasta);
				pastas.mkdirs();
				
				pCenarios = new File(ambienteTrabalho+this.pastaCenarios);
				if(!pCenarios.exists()) {
				pCenarios.mkdirs();
				}else {
					JOptionPane.showMessageDialog(null, "Foi constatado que já possui a pasta Cenarios!\nOs arquivos serão preservados e não havrá modificações.\nOs Cenários poderão ser utilizados normalmente.", "Os Cenários Já Existem", JOptionPane.INFORMATION_MESSAGE);
				}
		
		
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
			
			
			

		} catch (Exception e) {
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
		
		File isArquivo;

		isArquivo = new File(this.pasta+"\\"+this.arquivo);

		
		return(isArquivo.exists());
	}
	

}
