import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Rappresenta un file di testo. Permette di eseguire operazioni di lettura e scritture su un file di testo
 * gli attributi sono: un carattere(W o R)che servono per indicare se il file è aperto in lettura o scrittura,
 * un istanza della classe BufferedReader che permette di eseguire operazioni di lettura e 
 * un'istanza della classe BufferedWriter che permette di eseguire operazioni di scrittura
 * 
 * @author Radu Grigoras
 * @version 1.0
 */

public class TextFile 
{
	private char mode;
	private  BufferedReader reader;
	private BufferedWriter writer;
	
	/**
	 * Costruttore. 
	 * @param fileName rappreenta il nome del file
	 * @param mode rappresenta un carattere(W o R)per aprire il file in scrittura o in letura
	 * @throws IOException eccezzione che si verifica quando non è possibile aprire o creare il file
	 */
	
	public TextFile(String nomeFile, char mode) throws IOException
	{
		this.mode='R';
		if (mode=='W' ||mode=='w')
		{
			this.mode='W';
			writer=new BufferedWriter(new FileWriter(nomeFile,true));
		}
		else
			reader=new BufferedReader(new FileReader(nomeFile));
	}
	
	/**
	 * Scrive una linea di testo sul file di testo aperto in scrittura
	 * @param line rappresenta la riga di testo da scrivere su file
	 * @throws FileException ecezione che si verifica quando si tenta la lettura su un file aperto in scrittura
	 * @throws IOException eccezione che si verifica quando non è possibile scrivere su file
	 */
	
	public void toFile(String line) throws IOException, FileException
	{
		if (mode=='R')
			throw new FileException("File aperto in lettura");
		writer.write(line);
		writer.newLine();
	}
	
	/**
	 * legge una riga di testo da un file di testo aperto in lettura
	 * @return la riga letta dal file
	 * @throws FileException eccezione che si verifica quando si tenta di scrivere su un file aperto in lettura,
	 *		   oppure quando i tenta di leggere una riga del file ma non ci sono più righe da leggere o sono già state tutte lette
	 * @throws IOException eccezione che si verifica quando non è possibile legere da file
	 */
	
	public String fromFile() throws FileException, IOException, EccezioneTextFileEOF
	{
		String line;
		if (mode=='W')
			throw new FileException("File aperto in scrittura");
		line=reader.readLine();
		if (line==null)
			throw new EccezioneTextFileEOF();
		return line;
		
	}
	
	/**
	 * Chiude il file
	 * @throws IOException eccezione che si verifica nel caso non sia possibile accedere al file
	 */
	
	public void closeFile() throws IOException
	{
		if (mode=='R')
			reader.close();
		else
			writer.close();
	}
	
}
