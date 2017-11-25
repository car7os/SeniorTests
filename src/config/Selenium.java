package config;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Selenium {
	
	private static File drive;
	
	private boolean flag;
	
	
	public Selenium() {
		
		
		getDrive();
	}
	
	public void getDrive() {
		
		this.drive = null;
		this.flag = false;
		
		JOptionPane.showMessageDialog(null, "É necessario que selecione o ChromeDriver do Selenium", "Configuração do Selenium", JOptionPane.WARNING_MESSAGE);
		
		JFileChooser selecionarArquivo = new JFileChooser();
				
		int Selecionado = selecionarArquivo.showOpenDialog(null);
		
		if (Selecionado == JFileChooser.APPROVE_OPTION) {
			this.drive = selecionarArquivo.getSelectedFile();
			this.flag = true;
		}else {
			
			this.flag = false;
			JOptionPane.showMessageDialog(null, "O ChromeDriver do Selenium nao foi selecionado", "Configuração do Selenium", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
