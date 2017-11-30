package principal;

import java.io.IOException;

import javax.swing.JOptionPane;

import config.Cadastrar;;

public class SeniorTests {
	
	private static final String projeto = "exemplo.jar";
	
	private static String cenario;
	
	
	
	public static void main (String args[]) {
		
		JOptionPane selecionarCenario = new JOptionPane();
		
		cenario = selecionarCenario.showInputDialog(null, "Insira o Cenário: ");
		
		if (cenario == null || cenario.length()<0){
			System.exit(0);
			}else {
				if (cenario.equals("config")) {
					Cadastrar Configurar = new Cadastrar();
					}else {
						try {
							Runtime.getRuntime().exec("java -jar "+projeto+" "+cenario);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
						}
				}
		}
}
