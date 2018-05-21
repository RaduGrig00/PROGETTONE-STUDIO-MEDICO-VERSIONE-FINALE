import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe per le operazioni di input dalla tastiera
 * @author Radu Grigoras
 * @version 1.0
 */

public class ConsoleInput 
{

	private InputStreamReader input;
	private BufferedReader reader;
	
	/**
	 * Costruttore
	 */
	
	public ConsoleInput ()
	{
		input=new InputStreamReader (System.in);
		reader=new BufferedReader(input);
	}
	
	/**
	 * @return valore intero letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public int readInt() throws NumberFormatException, IOException
	{
		return (Integer.parseInt(reader.readLine()));
	}
	
	/** 
	 * @return  valore short letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public short readShort() throws NumberFormatException, IOException
	{
		return (Short.parseShort(reader.readLine()));
	}
	
	/** 
	 * @return  valore long letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public long readLong() throws NumberFormatException, IOException
	{
		return (Long.parseLong(reader.readLine()));
	}
	
	/** 
	 * @return  valore byte letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public byte readByte() throws NumberFormatException, IOException
	{
		return (Byte.parseByte(reader.readLine()));
	}
	
	/** 
	 * @return  valore float letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public float readFloat() throws NumberFormatException, IOException
	{
		return (Float.parseFloat(reader.readLine()));
	}
	
	/** 
	 * @return  valore double letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public double readDouble() throws NumberFormatException, IOException
	{
		return (Double.parseDouble(reader.readLine()));
	}
	
	/** 
	 * @return  valore boolean letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public boolean readBoolean() throws NumberFormatException, IOException
	{
		return (Boolean.parseBoolean(reader.readLine()));
	}
	
	/** 
	 * @return  carattere letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public char readsChar() throws IOException
	{
		return (reader.readLine().charAt(0));
	}
	
	/** 
	 * @return  stringa letta
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	
	public String readString() throws IOException
	{
		return reader.readLine();
	}
{
		
	}
}
