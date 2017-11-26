package config;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import log.LogAtividades;

public class Selenium {
	
	private static String drive;
	private static WebDriver driver; 
	
	private static String baseURL;
	
	private static WebElement areaTexto;
	
	public void abrirNavegador() {
		getDrive();
		
		System.setProperty("webdriver.chrome.driver", drive);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	public void getDrive() {
		
		String chromeDriver = "chromedriver.exe";
		
		File arquivo = new File(chromeDriver);
		
		if(arquivo.exists()) {
			
			this.drive = chromeDriver;
			
		}else {
		
		
		
		JOptionPane.showMessageDialog(null, "É necessario que selecione o ChromeDriver do Selenium", "Configuração do Selenium", JOptionPane.WARNING_MESSAGE);
		
		JFileChooser selecionarArquivo = new JFileChooser();
				
		int Selecionado = selecionarArquivo.showOpenDialog(null);
		
		if (Selecionado == JFileChooser.APPROVE_OPTION) {
			this.drive = selecionarArquivo.getSelectedFile().getAbsolutePath();
		}else {
			
			JOptionPane.showMessageDialog(null, "O ChromeDriver do Selenium nao foi selecionado", "Configuração do Selenium", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		}
	}
	
	public void abrirURL(String url) {
		
		this.baseURL = url;
		driver.get(this.baseURL);
	}
	
	public void inserirTexto(String campo, String valorCampo, String texto) {
		areaTexto = driver.findElement(By.xpath("//*[@"+campo+"='"+valorCampo+"']"));
		areaTexto.sendKeys(texto);
	}
	
	
	public void clicarLink(String texto) {
		driver.findElement(By.partialLinkText(texto)).click();
	}
	
	public void inserirTextoComSubmit(String campo, String valorCampo, String texto) {
		areaTexto = driver.findElement(By.xpath("//*[@"+campo+"='"+valorCampo+"']"));
		areaTexto.sendKeys(texto);
		areaTexto.submit();
	}
	
	public void apagarCampoTexto(String campo, String valorCampo) {
		areaTexto = driver.findElement(By.xpath("//*[@"+campo+"='"+valorCampo+"']"));
		areaTexto.clear();
	}
	
	public void fecharAbaAtual() {
		driver.switchTo().window(driver.getWindowHandle());
		driver.close();
	}
	
	public void fecharTodasAbas() {
		driver.quit();
	}
	
	public void fecharProcesso(String processo){
	
		try {
			for(int i = 0; i>= 100; i++) {

				Runtime.getRuntime().exec("taskkill /f /im "+processo+" /t");
			}
		}catch(Exception e) {
			
			LogAtividades log = new LogAtividades();
			
			log.setAtividades("Config Selenium","ERRO",e.getMessage());
		}
	}
	

	

}
