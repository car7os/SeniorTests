package log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LogAtividades {
	
	private static String pasta;
	
	
	public void setAtividades(String classe, String aviso, String texto) {
		
		this.pasta = "log";

		try {
			
			File pastas = new File(this.pasta);
			pastas.mkdirs();
			
			GregorianCalendar dataHora = new GregorianCalendar();
						
			FileWriter arquivoLog = new FileWriter(this.pasta+"\\"+dataHora.get(Calendar.DAY_OF_MONTH)+"-"+(dataHora.get(Calendar.MONTH)+1)+"-"+dataHora.get(Calendar.YEAR)+"-log.txt", true);
			PrintWriter gravar = new PrintWriter(arquivoLog);
			
			gravar.printf("\n[%s] (Clase: %s; Aviso: %s) { >>> "
					+ "%s"
					+ " <<< }\n"
					, dataHora.getTime(), classe, aviso, texto);

			arquivoLog.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
