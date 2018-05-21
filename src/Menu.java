
import java.io.IOException;

/**
 * Rappresenta un menu. Consente di Creare un menu con delle voci numeriche e di effettuare i controlli sulla
 * correttezza del dato inserito da parte dell'utente. Consente all'utente di inserire solamente valori numerici compresi fra 
 * 0 e (numero di voci del menu)-1. In caso di inserimento non corrretto o non conforme al formato richiesto
 * l'utente viene invitato ad eseguire nuovamente la scelta.
 * Gli attributi sono: una stringa che rappresenta il titolo(il nome)del menu', un elenco di stringhe che rappresentano le varie voci del menu', 
 * un intero che rappresenta il numero di voci di cui è composto il menu'.
 * 
 * @author Radu Grigoras
 * @version 1.0
 */

public class Menu 
{
	private int numeroVoci;
	private String[] elencoVoci;
	
	/**
	 * Costruttore
	 * @param elencoVoci Array rappresenta un array di stringhe di cui ogni elemento rappresenta una voce del menu da costruire
	 */
	
	public Menu(String[] elenco)
	{
		numeroVoci=elenco.length;
		elencoVoci=new String[numeroVoci];
		for (int i = 0; i < numeroVoci; i++) 
		{
			elencoVoci[i]=elenco[i];
		}
	}
	
	/**
	 * Visualizza sul monitor tutte le voci del menu
	 */
	
	public void visualizza()
	{
		for (int i = 0; i < numeroVoci; i++) 
		{
			System.out.println(elencoVoci[i]);
		}
	}
	
	/**
	 * Consente all'utente di scegliere fra una delle voci numeriche del menu. In caso di scelta non corretta 
	 * o formato del dato inserito non conforme l'utente deve effettuare nuovamente la propria scelta.
	 * @return Il numero intero che corrispondente alla voce del menu scelta dall'utente.
	 */
	
	public int scelta()
	{
		ConsoleInput tastiera= new ConsoleInput();
		int voceScelta=-1;
		do
		{
			visualizza();
			System.out.println("Scegli...");
			try 
			{
				voceScelta=tastiera.readInt();
				if(voceScelta>=numeroVoci || voceScelta<0)
				{
					System.out.println("Opzione non disponibile");
				}
			} catch (NumberFormatException e) 
			{
				System.out.println("Formato dato non corretto. Rinserire");
			}
			catch(IOException e)
			{
				System.out.println("Impossibile leggere dal dispositivo di input. Riprovare");
			}
		}while(voceScelta<0 || voceScelta>=numeroVoci);
		return voceScelta;
	}
}
