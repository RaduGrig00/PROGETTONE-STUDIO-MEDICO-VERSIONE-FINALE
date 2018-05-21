import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * La classe Visite rappresente una visita medica di un paziente dello studio medico. La classe è costituita dai seguenti attributi:
 * L'Id della visita che la identifica
 * Il Nome del paziente a cui è stata programmata la visita
 * Il Cognome del paziente a cui è stata programmata la visita
 * Il Nome del medico a cui è stata assegnata la visita
 * Il Cognome del medico a cui è stata assegnata la visita 
 * Il valore booleano visitaSvolta che indica se la visita è stata svolta o meno
 * La data e l'ora in cui la visita è stata pianificata
 * @author Radu Grigoras
 * @version 1.0
 *
 */

public class Visite implements Serializable
{
	//Attributi
	private int id;
	private String nomeP;
	private String cognomeP;
	private String nomeM;
	private String cognomeM;
	private Boolean visitaSvolta=false;
	private LocalDateTime dataOra;
	
	/**
	 * Costruttore della classe visite. Instanzia una nuova visita.
	 * Richiede l'Id, il nome e il cognome del paziente e del medico e
	 * la data e l'orario
	 * 	
	 * @param Id rappresenta il numero identificativo della visita+
	 * @param Il Nome del paziente a cui è stata programmata la visita
	 * @param Il Cognome del paziente a cui è stata programmata la visita
	 * @param Il Nome del medico a cui è stata assegnata la visita
	 * @param Il Cognome del medico a cui è stata assegnata la visita 
	 * @param DataOra rappresenta la data e l'orario in cui la visita è programmata
	 */
	
	//Costruttori
	public Visite (int id, String nomeP,String cognomeP,String nomeM,String cognomeM, LocalDateTime dataOra)
	{
		setId(id);
		setNomeP(nomeP);
		setCognomeP(cognomeP);
		setNomeM(nomeM);
		setCognomeM(cognomeM);
		setVisitaSvolta(visitaSvolta);
		setDataOra(dataOra);
	}
	
	/**
	 * Costruttore di copia della classe Visite. Istanzia una nuova visita
	 * @param Visite rappresenta la visita di cui si vuole creare una copia
	 */
	
	public Visite (Visite i)
	{
		this.id = i.getId();
		setNomeP(i.getNomeP());
		setCognomeP(i.getCognomeP());
		setNomeM(i.getNomeM());
		setCognomeM(i.getCognomeM());	
		setVisitaSvolta(i.getVisitaSvolta());
		setDataOra(i.getDataOra());	
	}
	
	/**
	 * Costruttore di default della classe Visite. Istanzia una nuova visita vuota
	 */
	//COSTRUTTORE DEFAULT
	
	public Visite()
	{
		
		setId(0);
		setNomeP("");
		setCognomeP("");
		setNomeM("");
		setCognomeM("");
		setVisitaSvolta(false);
		setDataOra(null);
	}
	//getter e setter
	
	/**
	 * Metodo di tipo getter che restituisce l'Id
	 * @return Id
	 */
	
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare l'Id
	 * @param Id
	 */

	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il nome del paziente
	 * @return nomeP
	 */

	public String getNomeP() 
	{
		return nomeP;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare il nome del paziente
	 * @param nomeP
	 */

	public void setNomeP(String nomeP) 
	{
		this.nomeP = nomeP;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il cognome del paziente
	 * @return cognomeP
	 */

	public String getCognomeP() 
	{
		return cognomeP;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare il cognome del paziente
	 * @param cognomeP
	 */

	public void setCognomeP(String cognomeP) 
	{
		this.cognomeP = cognomeP;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il nome del medico
	 * @return nomeM
	 */
	
	public String getNomeM() 
	{
		return nomeM;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare il nome del medico
	 * @param nomeM
	 */
	
	public void setNomeM(String nomeM) 
	{
		this.nomeM = nomeM;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il cognome del medico
	 * @return cognomeM
	 */

	public String getCognomeM() 
	{
		return cognomeM;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare il cognome del medico
	 * @param cognomeM
	 */
	
	public void setCognomeM(String cognomeM) 
	{
		this.cognomeM = cognomeM;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la visitaSvolta
	 * @return visitaSvolta
	 */

	public Boolean getVisitaSvolta() 
	{
		return visitaSvolta;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la visitaSvolta
	 * @param visitaSvolta
	 */
	
	public void setVisitaSvolta(Boolean visitaSvolta) 
	{
		this.visitaSvolta = visitaSvolta;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la data e l'ora della visita
	 * @return dataOra
	 */

	public LocalDateTime getDataOra() 
	{
		return dataOra;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la data e l'ora della visita
	 * @param dataOra
	 */

	public void setDataOra(LocalDateTime dataOra) 
	{
		this.dataOra = dataOra;
	}
	
	/**
	 * Metodo toString che restituisce una stringa composta dall'Id, dal nome e il cognome del paziente e del medico e
	 * dalla data e l'ora
	 * @return Stringa composta dai parametri della visita
	 */
	
	public String toString()
	{
		return getId()+"/"+" Nome e cognome del paziente: "+getNomeP()+" "+getCognomeP()+"/ Nome e cognome del medico: "+getNomeM()+" "+getCognomeM()+"/ Data e ora della visita: "+getDataOra()+".";
	}

	
	/*public String toString() 
	{
		return(getId()+" "+getNomeP()+" "+getCognomeP()+getNomeM()+" "+getCognomeM()+" "+getVisitaSvolta()+" "+getData());
	}*/
	

}
