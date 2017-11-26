package config;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	
	private static String drive;
	private static WebDriver driver; 
	
	private static WebElement areaTexto;
	
	public Selenium() {
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
		driver.get(url);
	}
	
	public void inserirTexto(String campo, String valorCampo, String texto) {
		areaTexto = driver.findElement(By.xpath("//*[@"+campo+"='"+valorCampo+"']"));
		areaTexto.sendKeys(texto);
	}
	
	
	public void clicar(String campo, String valorCampo) {
		driver.findElement(By.xpath("//*[@"+campo+"='"+valorCampo+"']")).click();
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

}
