import java.io.Serializable;

/**
 * La classe Nodo rappresenta un nodo. Il nodo è costituito dai seguenti attributi:
 * un info e un link. Info è la componente informativa, contiene informazioni sugli elementi della lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Radu Grigoras
 * @version 1.0
 */

public class Nodo implements Serializable
{
	private Visite info;
	private Nodo link;
	
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede una visita, che rappresenta l'attributo info della classe nodo.
	 * 
	 * @param visite rappresenta oggetto di tipo visite
	 */
	
	public Nodo(Visite visita)
	{
		setInfo(visita);
		link=null;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia una visita
	 * @return info che rappresenta un oggetto Visite
	 */

	public Visite getInfo() 
	{
		return info;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta la Visita che rappresenterà la componente in formativa del nodo
	 */

	public void setInfo(Visite info) 
	{
		this.info = info;
	}
	
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */

	public Nodo getLink() 
	{
		return link;
	}
	
	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
