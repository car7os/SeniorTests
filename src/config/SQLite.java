package config;

import log.LogAtividades;

public class SQLite {
	
	private static String arquivo;
	
	
	public SQLite(){
		
		LogAtividades log = new LogAtividades();
		
		log.setAtividades("Classe", "Aviso", "Texto");
			
		this.arquivo = "tests.db";
		
		
		
		
	}
	

}
