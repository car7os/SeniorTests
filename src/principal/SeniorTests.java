package principal;

import config.SQLite;
import config.Selenium;

public class SeniorTests {
	
	public static void main (String args[]) {
		
		SQLite DataBase = new SQLite();
		Selenium site = new Selenium();
		
		site.abrirNavegador();
		
		site.abrirURL("http://www.google.com.br");
		
		site.inserirTexto("name","q", "microsoft");
		
		site.apagarCampoTexto("name", "q");
		
		site.inserirTextoComSubmit("name", "q", "Radio CBN");
		
		site.clicarLink("CBN - Home");

		
		
		
		
	}

}
