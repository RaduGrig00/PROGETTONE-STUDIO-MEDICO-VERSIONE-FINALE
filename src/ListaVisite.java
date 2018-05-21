import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * La classe rappresenta una Lista di Visite, in particolare le visite dei pazienti allo studio medico
 * gli attributi sono: il puntatore head di tipo nodo e il numero di elementi(Visite) del laboratorio
 * La classe mette a disposizione tutti i metodi necessari per la gestione delle visite
 *  
 * @author Radu Grigoras
 * @version 1.0
 */

public class ListaVisite implements Serializable
{
	private Nodo head;
	private int elementi;
	
	
		/**
		 * Metodo costruttore. Consente di creare una lista di visite vuota, senza alcuna visita
		 */
	
	//Costruttore lista visite
	public ListaVisite()
	{
		head=null;
		elementi=0;
	}
	
	/**
	 * Metodo costruttore di copia di ListaVisite. Consente di creare una lista di visite uguale a ListaVisite
	 * @param ListaVisite
	 */
	public ListaVisite(ListaVisite i)
	{
		this.head=i.head;
		this.elementi=i.elementi;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il numero di elementi di cui è composta la ListaVisite, ossia il numero di visite registrate
	 * @return elementi, rappresenta il numero delle visite registrate nello studio medico
	 */
	
	//getter che restituisce elementi
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * Metodo privato che permette di creare un oggetto di nodo
	 * @param info rappresenta la componente informativa , ossia un accesso
	 * @param link rappresenta il reference al nodo successivo
	 * @return nodo, che rappresenta il nodo creato
	 */
	
	private Nodo creaNodo(Visite visita1, Nodo link)
	{
		Nodo nodo= new Nodo(visita1);
		nodo.setLink(link);
		return nodo;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il nodo puntato da head
	 * @return head che rappresenta il nodo puntato
	 */
	
	public Nodo getHead()
	{
		return head;
	}
	
	/**
	 * Metodo privato che restituisce un oggetto di tipo nodo in una detrminata posizione
	 * @param posizione rappresenta la posizine di cui si vuole ricavare il nodo
	 * @return p che rappresenta il nodo che i ottiene nella posizione desiderata
	 * @throws VisitaException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
	
	private Nodo getLinkPosizione(int posizione) throws VisitaException 
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new VisitaException("Posizione non valida");
		if (elementi==0)
			throw new VisitaException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	
			n++;
		}
		
		return p;
	}
	
	/**
	 * Metodo che permette di inserire una visita in testa
	 * @param info rappresenta la componente informativa, ossia una visita
	 */
	
	public void inserisciInTesta (Visite visita1)
	{
		
		Nodo p=creaNodo(visita1, head);
		head=p;
		elementi++;
	}
	
	/**
	 * Metodo che restituisce una stringa formata da tutti gli accessi con i relativi dati
	 */
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	/**
	 * Metodo che permette di inserire una visita in coda
	 * @param info rappresenta la componente informativa, ossia un accesso
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota
	 */
	
	public void inserisciInCoda(Visite visita1) throws VisitaException 
	{
		if(elementi==0)
		{
			inserisciInTesta(visita1);
			return;
		}
		
		Nodo pn=creaNodo(visita1, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	/**
	 * Metodo che permette di inserire una visita,ovvero di creare un nodo in una determinata posizione della lista
	 * @param info rappresenta la componente informativa, ossia un accesso da inserire nella posizione
	 * @param posizione rappresenta la posizione nella quale inserire l'oggetto di tipo Visita
	 * @throws VisitaException eccezione che si verifica se la posizione non è valida
	 */
	
	public void inserisciInPosizione(Visite visita1,int posizione) throws VisitaException 
	{
		if (posizione<=1)
		{
			inserisciInTesta(visita1);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(visita1);
			return;
		}
		
		Nodo pn=creaNodo(visita1, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	/**
	 * Metodo che  consente di eliminare l'elemento in testa alla lista 
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 */
	
	public void eliminaInTesta(int posizione) throws VisitaException, IOException, FileException
	{
		if (elementi==0)
			throw new VisitaException("Lista vuota");
		head=head.getLink();
		elementi--;	
	}
	
	/**
	 * Metodo che consente di eliminare l'elemento in coda alla lista
	 * @throws VisitaException eccezione che si verifica quando la posizione è vuota
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 */
	
	public void eliminaInCoda(int posizione) throws VisitaException, FileException, IOException
	{
		if (elementi==0)
			throw new VisitaException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta(posizione);
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	/**
	 * Metodo che consente di eliminare un elemento,ossia un nodo della lista nella posizione desiderata
	 * @param posizione rappresenta la posizione nella quale si vuole effetuare l'eliminazione del nodo
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 */
	
	public void eliminaInPosizione(int posizione) throws VisitaException, IOException, FileException
	{
		if (elementi==0)
			throw new VisitaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new VisitaException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta(posizione);
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda(posizione);
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	

	/**
	 * Metodo che consente di eliminare una visita dalla lista per poi salvara su un file di testo esterno
	 * @param Id rappresenta l'Id della visita che si vuole eliminare
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 */
	
	public void eliminaVisita(int Id) throws VisitaException, IOException, FileException
	{
		if(elementi==0)
			throw new VisitaException("Lista vuota");
		for (int i = 1; i <= elementi; i++) 
		{
				boolean avvenutaEliminazione = false;
				if((i==1)&&(getLinkPosizione(i).getInfo().getId()==Id))
				{
					esportaCSV("PrenotazioniAnnullate.txt",Id);
					eliminaInTesta(Id);
					avvenutaEliminazione=true;
					return;
				}
				
				if((i==elementi)&&(getLinkPosizione(i).getInfo().getId()==Id))
				{
					esportaCSV("PrenotazioniAnnullate.txt",Id);
					eliminaInCoda(Id);
					avvenutaEliminazione=true;
					return;
				}
				if(avvenutaEliminazione==false)
					{
						if(getLinkPosizione(i).getInfo().getId()==Id)
						{
							
							Nodo p=getLinkPosizione(Id);
							Nodo precedente=getLinkPosizione(Id-1);
							precedente.setLink(p.getLink());
							elementi--;
							esportaCSV("PrenotazioniAnnullate.txt",Id);
						}
					}
				if(elementi>0 && getLinkPosizione(i).getInfo().getId()==Id)
					i=0;
				}
				
	}
	
	/**
	 * Metodo che permette di recuperare i dati della visita in una determinata posizione
	 * @param posizione rappresenta la posizione nella quale si desidera recuperare i dati
	 * @return i dati dell'accesso nella posizione desoderata
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	
	public String visita (int posizione) throws VisitaException 
	{
		if (elementi==0)
			throw new VisitaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new VisitaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	/**
	 * Metodo che permette di recuperare i dati della visita in una determinata posizione
	 * @param posizione rappresenta la posizione nella quale si desidera recuperare i dati
	 * @return i dati dell'accesso nella posizione desoderata
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	//è uguale a quello sopra ma me ne sono accorto troppo tardi e rimuovere e correggere eventuali errori sarebbe troppo lungo
	public Visite getVisita (int posizione) throws VisitaException 
	{
		if (elementi==0)
			throw new VisitaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new VisitaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	/**
	 * Metodo che permette di eseguire una visita mostrando i dati sul monitor e settando visitaSvolta a true
	 * @param Id rappresenta la visita che si vuole eseguire
	 * @throws VisitaException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	
	public void eseguiVisita(int Id) throws VisitaException
	{
		if(elementi==0)
			throw new VisitaException("Lista vuota");
		Nodo p=head;
	
		for (int i = 1; i <= elementi; i++) 
		{
			if(p.getInfo().getId()==Id)
			p.getInfo().setVisitaSvolta(true);
			System.out.println(p.getInfo().toString());
		}
		{
			if(p.getInfo().getId()!=Id)
			System.out.println("Nessuna visita con questo Id: "+Id);
		}
	}
	
	/**
	 * Metodo che permette di salvare i dati della ListaVisite su un file di testo in formato CSV
	 * @param nomeFile rappresente il file sul quale si andrà a salvare e posizione la posizione della visita nella lista
	 * @throws IOException eccezione che si verifica per errori durante la scrittura su file
	 * @throws FileException ecczione che si verifica se si prova a leggere
	 * @throws VisitaException eccezione che si verifica se la lista di cui si vogliono salvare i dati è vuota
	 */
	
	public void esportaCSV (String nomeFile, int posizione) throws IOException, VisitaException, FileException
	{
		Visite visita1;
		String visitaCSV;
		
		TextFile file= new TextFile (nomeFile,'W');
		
		visita1=getVisita(posizione);
		visitaCSV=visita1.getId()+";"+visita1.getNomeP()+";"+visita1.getCognomeP()+";"+visita1.getNomeM()+";"+visita1.getCognomeM()+";"+visita1.getDataOra().getYear()+";"+visita1.getDataOra().getMonth()+";"+visita1.getDataOra().getDayOfWeek()+";"+visita1.getDataOra().getHour()+";"+visita1.getDataOra().getMinute()+";";
		file.toFile(visitaCSV);
		
		file.closeFile();
		
	}

	/**
	 * Metodo che permette di caricare i dati della ListaVisite da un file di testo in formato CSV
	 * @param nomeFile rappresenta il file dal quale si caricheranno i dati
	 * @throws IOException eccezione che si verifica per errori durante la scrittura su file
	 * @throws FileException ecczione che si verifica se si prova a leggere
	 * @throws VisitaException eccezione che si verifica se la lista di cui si vogliono salvare i dati è vuota
	 */
	
	public ListaVisite importaCSV (String nomeFile) throws IOException, FileException, VisitaException, EccezioneTextFileEOF
	{
		ListaVisite listaVisite=new ListaVisite();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiVisite;
		Visite visita1 = null;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiVisite=rigaLetta.split(";");
					int Id = visita1.getId();
					String NomeP = visita1.getNomeP();
					String CognomeP = visita1.getCognomeP();
					String NomeM = visita1.getNomeM();
					String CognomeM = visita1.getCognomeM();
					LocalDateTime dataOra = visita1.getDataOra();
					visita1 = new Visite(Id, NomeP, CognomeP, NomeM, CognomeM, dataOra);
					listaVisite.inserisciInCoda(visita1);
				}
				
			} 
			catch (FileException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new FileException(e.toString());
			}
		
			return listaVisite;		
			
	}
	
	/**
	 * Metodo che consente di salvare la ListaVisite in un file binario
	 * @param nomeFile rappresenta il nome del file sul quale si vuole salvare l'oggetto
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 */
	
	public void salvaListaVisite(String nomeFile) throws IOException
	{
		FileOutputStream file=new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		
		writer.writeObject(this);
		writer.flush();
		writer.close();
		
	}
	
	/**
	 *  Metodo che consente di caricare un'oggetto di tipo ListaVisite effettuandone la deserializzazione da file binario
	 * @param nomeFile rappresenta il file da cui si effettua la deserializzazione
	 * @return la ListaVisite
	 * @throws IOException eccezione che si verifica per errori durante il caricamento della Visita
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo ListaVisite
	 */
	
	public ListaVisite caricaListaVisite (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		ListaVisite listaVisite;
		listaVisite=(ListaVisite)(reader.readObject());
		file.close();
		return listaVisite;
	}

}
	
	

