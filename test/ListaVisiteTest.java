import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;

public class ListaVisiteTest 
{
	LocalDateTime now = LocalDateTime.now();
	Visite v1 = new Visite(1,"Davide","Carizzoni","Bob","Marley",now);
	Visite v2 = new Visite(2, "Bob","Marley","Davide","Carizzoni", now.plusMinutes(30));
	Visite v3 = new Visite(3, "Radu","Grigoras","Pamela","Anderson", now.plusMinutes(40));
	
	
	@Test
	public void testCostruttoreListaVisite() 
	{
		ListaVisite listaVisite = new ListaVisite();
		assertEquals(listaVisite.getElementi(), 0);
	}

	@Test
	public void testCostruttoreDiCopiaListaVisite() 
	{
		ListaVisite lv = new ListaVisite();
		ListaVisite lv1= new ListaVisite(lv);
		
		assertTrue("Costruttore copia listaVisite", lv.getHead()==lv1.getHead() && lv.getElementi()==lv1.getElementi());	
	}

	@Test
	public void testGetElementi() 
	{
		ListaVisite listaVisite = new ListaVisite();
		assertEquals(listaVisite.getElementi(), 0);
		listaVisite.inserisciInTesta(v1);
		assertEquals(listaVisite.getElementi(), 1);
	}

	@Test
	public void testInserisciInTesta() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		assertEquals(lv1.getVisita(1), v1);
	}


	@Test
	public void testInserisciInCoda() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);	
		lv1.inserisciInTesta(v2);
		assertEquals(lv1.getVisita(2), v1);  
		lv1.inserisciInCoda(v3);  
		assertEquals(lv1.getVisita(3), v3); 
	}

	@Test
	public void testInserisciInPosizione() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.inserisciInTesta(v2);
		lv1.inserisciInTesta(v3); 
		lv1.inserisciInPosizione(v1, 2); 
		assertEquals(lv1.getVisita(1), v3);
		assertEquals(lv1.getVisita(2), v1);
		assertEquals(lv1.getVisita(3), v2);
		assertEquals(lv1.getVisita(4), v1);
	}

	@Test
	public void testEliminaInTesta() throws VisitaException, IOException, FileException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.eliminaInTesta(0);
		assertTrue("EliminaInCoda", lv1.getHead()==null);
	}
	
	@Test (expected=VisitaException.class)
	public void testEliminaInTestaLaboratorioVuoto() throws VisitaException, FileException, IOException 
	{
		ListaVisite lv1=new ListaVisite();
		lv1.eliminaInTesta(0);
	}

	@Test
	public void testEliminaInCoda() throws VisitaException, FileException, IOException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.eliminaInCoda(0);
		assertTrue("EliminaInCoda", lv1.getHead()==null);
		
	}
	
	@Test (expected=VisitaException.class)
	public void testEliminaInCodaLaboratorioVuoto() throws VisitaException, FileException, IOException 
	{
		ListaVisite lv1=new ListaVisite();
		lv1.eliminaInCoda(0);
	}

	@Test
	public void testEliminaInPosizione() throws VisitaException, IOException, FileException
	{
		ListaVisite lv1=new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.inserisciInTesta(v2);
		lv1.inserisciInTesta(v3); 
		lv1.eliminaInPosizione(2); 
		assertEquals(lv1.getVisita(1), v3); 
		assertEquals(lv1.getVisita(2), v1);
		lv1.eliminaInPosizione(2); 
		assertEquals(lv1.getVisita(1), v3);
		
	}


	@Test
	public void testGetVisita() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		assertTrue("getVisita",lv1.getVisita(1).getId()==v1.getId() && lv1.getVisita(1).getNomeP()==v1.getNomeP() && lv1.getVisita(1).getCognomeP()==v1.getCognomeP()  && lv1.getVisita(1).getNomeM()==v1.getNomeM() && lv1.getVisita(1).getCognomeM()==v1.getCognomeM() && lv1.getVisita(1).getVisitaSvolta()==v1.getVisitaSvolta()&& lv1.getVisita(1).getDataOra()==v1.getDataOra() );
	}
	
	@Test (expected=VisitaException.class)
	public void testGetAccessoLaboratorioVuoto() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.getVisita(1);
	}
	
	@Test (expected=VisitaException.class)
	public void testGetAccessoPosizioneNonValida() throws VisitaException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.getVisita(2);
	}

	@Test
	public void testEsportaCSV() throws IOException, VisitaException, FileException, EccezioneTextFileEOF 
	{
		LocalDateTime dataOra=LocalDateTime.of(2019, 6, 1, 12, 12);
		String nomeFile="test.txt";
		ListaVisite lv1=new ListaVisite();
		Visite v4 = new Visite (1,"Davide","Carizzoni","Bob","Marley",dataOra);
		lv1.inserisciInTesta(v4);
		lv1.esportaCSV(nomeFile, 1);
		TextFile file=new TextFile(nomeFile,'R');
		String StringaLetta=file.fromFile();
		String visitaCSV=v4.getId()+";"+v4.getNomeP()+";"+v4.getCognomeP()+";"+v4.getNomeM()+";"+v4.getCognomeM()+";"+v4.getDataOra().getYear()+";"+v4.getDataOra().getMonth()+";"+v4.getDataOra().getDayOfWeek()+";"+v4.getDataOra().getHour()+";"+v4.getDataOra().getMinute()+";";
		assertTrue("EsportaLaboratorioCSV",StringaLetta.compareTo(visitaCSV)==0);
	}

	@Test
	public void testSalvaCaricaListaVisite() throws IOException, ClassNotFoundException 
	{
		ListaVisite lv1 = new ListaVisite();
		lv1.inserisciInTesta(v1);
		lv1.salvaListaVisite("test.bin");
		ListaVisite lv2=lv1.caricaListaVisite("test.bin");
		assertTrue("Salva e carica listaVisite",lv1.toString().compareTo(lv2.toString())==0);
	}
	

}
