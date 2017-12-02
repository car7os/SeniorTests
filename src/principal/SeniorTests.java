package principal;

import java.io.IOException;

import javax.swing.JOptionPane;

import config.Cadastrar;;

public class SeniorTests {
	
	
	
	private static String executavelJAR;
	
	private static String cenario;
	
	
	
	public static void main (String args[]) {
		
		
		while(true) {
		
		JOptionPane selecionarCenario = new JOptionPane();
		
		cenario = null;
		
		cenario = selecionarCenario.showInputDialog(null, "Insira o Cenário: ");
		
		if (cenario == null || cenario.equals("") || cenario.equals("sair") || cenario.equals("fechar")){
			System.exit(0);
			}else {
				if (cenario.equals("config")) {
					Cadastrar Configurar = new Cadastrar();
					}else {
						try {
							Runtime.getRuntime().exec("java -jar "+executavelJAR+" "+cenario);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
						}
				}
		}
	}
}
