import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthSeparatorUI;


/**
 * La classe Ordinatore rappresenta un ordinatore. Serve per ordinare una serie di elementi in ordine crescente o alfabetico
 * 
 * @author Radu Grigoras
 * @version 1.0
 */

public class Ordinatore 
{	

	/**
	 * Metodo che consente di scambiare due visite della lista rispettivamente in posizione 1 e posizione 2
	 * @param visite rappresenta la lista visite sulla quale si desidera effettuare lo scambio
	 * @param pos1 rappresenta la posizione della prima Visita da scambiare
	 * @param pos2 rappresenta la posizione della seconda Visita da scambiare
	 * @throws VisitaException eccezione che si verifica quando le posizioni inserite non sono valide
	 */
	
	public static void scambia(ListaVisite visite, int pos1, int pos2) throws VisitaException, IOException, FileException 
	{
		if(pos1<=0 || pos1>visite.getElementi() || pos2<=0 ||pos2>visite.getElementi())
			throw new VisitaException("Posizioni non valide");
		Visite a1,a2;
		a1=new Visite(visite.getVisita(pos1));
		a2=new Visite(visite.getVisita(pos2));
	
		visite.inserisciInPosizione(a1, pos2);
		visite.inserisciInPosizione(a2, pos1);
		
		visite.eliminaInPosizione(pos2+2);
		visite.eliminaInPosizione(pos1+1);
	}

	/**
	 * Metodo che consente di copiare un oggetto ListaVisite.
	 * @param visite rappresenta la ListaVisite di cui si desidera creare una copia
	 * @return la copia della ListaVisite passata come parametro
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo ListaVisite
	 */
	
	private static ListaVisite copia(ListaVisite visite) throws IOException, ClassNotFoundException 
	{
		ListaVisite v2=new ListaVisite();
		visite.salvaListaVisite("copia.bin");
		v2=v2.caricaListaVisite("copia.bin");
		return v2;
	}
	
	/**
	 * Metodo che permette di ordinare le visite di una ListaVisite in ordine crescente, quindi dal più recente al meno recente
	 * @param visite rappresenta la ListaVisite da ordinare in maniera crescente
	 * @return la ListaVisite ordinata
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo ListaVisite
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws VisitaException eccezione che si verifica quando le posizioni non sono valide
	 */
	
	public static ListaVisite selectionSortCrescenteNodi(ListaVisite visite) throws ClassNotFoundException, IOException, FileException, VisitaException
	{
		ListaVisite visitaCopia=copia(visite);
		boolean scambioAvvenuto;
		do
		{
			scambioAvvenuto=false;
			for (int i = 1; i < visitaCopia.getElementi(); i++) 
			{
				if(visitaCopia.getVisita(i).getDataOra().isAfter(visitaCopia.getVisita(i+1).getDataOra()))
				{
					scambia(visitaCopia,i,i+1);
					scambioAvvenuto=true;
				}
						
					
			}
		} while (scambioAvvenuto==true);
		return visitaCopia;
	}
	
	/**
	 * Metodo che permette di ordinare le visite di una ListaVisite in ordine alfabetico
	 * @param visite rappresenta la ListaVisite da ordinare in ordine alfabetico
	 * @return la ListaVisite ordinata
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo ListaVisite
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws VisitaException eccezione che si verifica quando le posizioni non sono valide
	 */
	
	public static ListaVisite selectionSortCrescenteAlfabetoNodi(ListaVisite visite) throws ClassNotFoundException, IOException, FileException, VisitaException
	{
		ListaVisite visitaCopia=copia(visite);
		boolean scambioAvvenuto;
		do
		{
			scambioAvvenuto=false;
			for (int i = 1; i < visitaCopia.getElementi(); i++) 
			{
				if(visitaCopia.getVisita(i).getNomeP().compareTo(visitaCopia.getVisita(i+1).getNomeP())==0)
				{
					if(visitaCopia.getVisita(i).getCognomeP().compareTo(visitaCopia.getVisita(i+1).getCognomeP())==0)
					{						
					}
					else if(visitaCopia.getVisita(i).getCognomeP().compareTo(visitaCopia.getVisita(i+1).getCognomeP())<0)
					{
					}
					else if(visitaCopia.getVisita(i).getCognomeP().compareTo(visitaCopia.getVisita(i+1).getCognomeP())>0)
					{
						scambia(visitaCopia,i,i+1);
						scambioAvvenuto=true;
					}
				}
				else if(visitaCopia.getVisita(i).getNomeP().compareTo(visitaCopia.getVisita(i+1).getNomeP())<0)
				{
				}
				else if(visitaCopia.getVisita(i).getNomeP().compareTo(visitaCopia.getVisita(i+1).getNomeP())>0)
				{
					scambia(visitaCopia,i,i+1);
					scambioAvvenuto=true;
				}
					
			}
		} while (scambioAvvenuto==true);
		return visitaCopia;
	}
}
	
	