package config;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Selenium {
	
	private static String browserDriver;
	private static String driver;
	private static String ambienteTrabalho;
	private static int confirma;
	
	
	
	public Selenium() {
		
		SQLite config = new SQLite();
		
		if (!config.getConfig()) {

			//configurarSelenium();
			configurarAmbiente();
		
		}
		
	}
	
	
	
	public void configurarSelenium() {
		
		this.browserDriver = null;
		this.driver = null;
		
		
		JOptionPane.showMessageDialog(null, "O Sistema n�o est� configurado!\n� necessario que Configure o Selenium selecionando o BrowserDriver, inserindo o WebDriver do Selenium e\nselecionando o diret�rio para montar o Ambiente de Trabalho.", "Configura��o do Sistema", JOptionPane.WARNING_MESSAGE);
		
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione o BrowserDriver do Selenium");
		int Selecionado = selecionarArquivo.showOpenDialog(null);
		
		if (Selecionado == JFileChooser.APPROVE_OPTION) {
			
			this.browserDriver = selecionarArquivo.getSelectedFile().getAbsolutePath();
		
		}else {
			
			JOptionPane.showMessageDialog(null, "O BrowserDriver do Selenium nao foi selecionado!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Sistema", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
		driver = JOptionPane.showInputDialog("Insira o WebDriver do Selenium:","webdriver.chrome.driver");
		
		if ( (driver == null) || (driver.length() < 15) ) {

			JOptionPane.showMessageDialog(null, "O WebDriver do Selenium nao foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Sistema", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		this.confirma = JOptionPane.showConfirmDialog(null, "Deseja continuar com esta configura��o?\n\nBrowserDriver: "+this.browserDriver+"\n\nWebDriver: "+this.driver+"\n\nCaso seja necess�rio configurar novamente, delete a pasta 'config'.", "Confima��o das Configura��es Selenium", JOptionPane.OK_CANCEL_OPTION);
		
		if (this.confirma == JOptionPane.CANCEL_OPTION) {

			JOptionPane.showMessageDialog(null, "O Selenium nao foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Selenium", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			
		}else {

			configurarAmbiente();
		
		}
	
	}
	
	public void configurarAmbiente () {
		JFileChooser chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Selecione o Diretorio Ambiente de Trabalho");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {

	    	ambienteTrabalho =  String.valueOf(chooser.getSelectedFile())+"\\";

	    	
			this.confirma = JOptionPane.showConfirmDialog(null, "Confirma as configura��es de Ambiente de Trabalho?\n\nDiret�rio do Ambiente de Trabalho:\n"+this.ambienteTrabalho+"\n\nCaso seja necess�rio configurar novamente, delete a pasta 'config'.", "Confima��o das Configura��es do Ambiente de Trabalho", JOptionPane.OK_CANCEL_OPTION);
			
			if (this.confirma == JOptionPane.CANCEL_OPTION) {

				JOptionPane.showMessageDialog(null, "O Selenium nao foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Selenium", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				
			}else {


		    	SQLite gravarConfiguracao = new SQLite(this.browserDriver, this.driver, this.ambienteTrabalho);
			
			}


	      }
	    else {
			JOptionPane.showMessageDialog(null, "O Ambiente de Trabalho n�o foi configurado corretamente!\nO sistema ser� finalizado devido a falta de configura��o.", "Configura��o do Ambiente de Trabalho", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
	      }
	}
}
	


