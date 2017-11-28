package config;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Selenium {
	
	private static String browserDriver;
	private static String driver;
	private static int confirma;
	
	
	public Selenium() {
		
		this.browserDriver = null;
		this.driver = null;
		
		
		JOptionPane.showMessageDialog(null, "O Selenium n�o est� configurado!\n� necessario que selecione o BrowserDriver do Selenium e configure o Driver.", "Configura��o do Selenium", JOptionPane.WARNING_MESSAGE);
		
		JFileChooser selecionarArquivo = new JFileChooser();
		int Selecionado = selecionarArquivo.showOpenDialog(null);
		
		if (Selecionado == JFileChooser.APPROVE_OPTION) {
			
			this.browserDriver = selecionarArquivo.getSelectedFile().getAbsolutePath();
		
		}else {
			
			JOptionPane.showMessageDialog(null, "O BrowserDriver do Selenium nao foi selecionado!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Selenium", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
		driver = JOptionPane.showInputDialog("Insira o Driver (ex: webdriver.chrome.driver)");
		
		if ( (driver == null) || (driver.length() < 15) ) {

			JOptionPane.showMessageDialog(null, "O Driver do Selenium nao foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Selenium", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		this.confirma = JOptionPane.showConfirmDialog(null, "BrowserDriver: "+this.browserDriver+"\n\nDriver: "+this.driver+"\n\nDeseja continuar com esta configura��o? Caso seja necess�rio configurar novamente, delete a pasta 'config'.", "Confima��o das Configura��es Selenium", JOptionPane.OK_CANCEL_OPTION);
		
		if (this.confirma == JOptionPane.CANCEL_OPTION) {

			JOptionPane.showMessageDialog(null, "O Selenium nao foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Selenium", JOptionPane.ERROR_MESSAGE);
			
		}

	
	}
}
	


