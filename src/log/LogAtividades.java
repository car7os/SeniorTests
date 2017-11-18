package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LogAtividades {
	
	
	public void setAtividades(String classe, String aviso, String texto) {

		try {
			
			GregorianCalendar dataHora = new GregorianCalendar();
			
			FileWriter arquivoLog = new FileWriter("log\\"+dataHora.get(Calendar.DAY_OF_MONTH)+"-"+(dataHora.get(Calendar.MONTH)+1)+"-"+dataHora.get(Calendar.YEAR)+"-log.txt", true);
			PrintWriter gravar = new PrintWriter(arquivoLog);
			
			gravar.printf(
					  "\n\n%s >>> Clase: %s // Aviso: %s\n{\n"
					+ "\nTexto:\n\n"
					+ "%s"
					+ "\n\n}\n--------------------------------------------------------------------------\n"
					, dataHora.getTime(), classe, aviso, texto);

			arquivoLog.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
