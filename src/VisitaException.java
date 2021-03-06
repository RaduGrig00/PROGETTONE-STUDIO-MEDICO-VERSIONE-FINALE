
/**
 * Classe che rappresenta un'eccezione sollevata in particolari casi.
 * L'attributo della classe � il messaggio che si vuole mostrare quando l'eccezione viene sollevata
 * @author Radu Grigoras
 * @version 1.0
 */

public class VisitaException extends Exception 
{
	private String messaggio;
	
	/**
	 * Costruttore 
	 * @param messaggio rappresenta il messaggio da mostrare
	 */
	
	public VisitaException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	/**
	 * Metodo to string che ritorna il messaggio da mostrare al verificarsi dell'eccezione
	 */
	
	public String toString()
	{
		return messaggio;
	}
}
