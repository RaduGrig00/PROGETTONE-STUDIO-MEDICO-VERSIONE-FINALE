import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class VisiteTest {

	@Test
	public void testVisiteCostruttore() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertTrue("Costruttore Visite",v1.getId()==1 && v1.getNomeP()=="Davide" && v1.getCognomeP()=="Carizzoni"&& v1.getNomeM()=="Bob"&& v1.getCognomeM()=="Marley"&& v1.getDataOra()==dataOra);
	}
	
	@Test
	public void testVisiteCostruttoreDiCopia() 
	{
		LocalDateTime dataOra=LocalDateTime.of(2019, 6, 1, 12, 12);
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		Visite v2=new Visite(v1);
		assertTrue("Costruttore copia Visite", v1.getId()==v2.getId() && v1.getNomeP()==v2.getNomeP() && v1.getCognomeP()==v2.getCognomeP() &&
		v1.getNomeM()==v2.getNomeM() && v1.getCognomeM()==v2.getCognomeM() && v1.getVisitaSvolta()==v2.getVisitaSvolta() && v1.getDataOra()==v2.getDataOra());
	}

	@Test
	public void testCostruttoreVuoto() 
	{
		Visite v3=new Visite();
		assertTrue("Costruttore Visite vuoto",v3.getId()==0 && v3.getNomeP()=="" && v3.getCognomeP()=="" && v3.getNomeM()==""&& v3.getCognomeM()==""&& v3.getDataOra()==null);
	}

	@Test
	public void testGetId() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals(1, v1.getId());
	}

	@Test
	public void testSetId() 
	{
		Visite v1=new Visite();
		v1.setId(1);
		assertEquals("setId",1,v1.getId());
	}

	@Test
	public void testGetNomeP() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals("Davide", v1.getNomeP());
	}

	@Test
	public void testSetNomeP() 
	{
		Visite v1=new Visite();
		v1.setNomeP("Davide");
		assertEquals("setNomeP","Davide",v1.getNomeP());
	}

	@Test
	public void testGetCognomeP() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals("Carizzoni", v1.getCognomeP());
	}

	@Test
	public void testSetCognomeP() 
	{
		Visite v1=new Visite();
		v1.setCognomeP("Carizzoni");
		assertEquals("setCognomeP","Carizzoni",v1.getCognomeP());
	}

	@Test
	public void testGetNomeM() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals("Bob", v1.getNomeM() );
	}

	@Test
	public void testSetNomeM() 
	{
		Visite v1=new Visite();
		v1.setNomeM("Bob");
		assertEquals("setNomeM","Bob",v1.getNomeM());
	}

	@Test
	public void testGetCognomeM() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals("Marley", v1.getCognomeM());
	}

	@Test
	public void testSetCognomeM() 
	{
		Visite v1=new Visite();
		v1.setCognomeM("Marley");
		assertEquals("setCognomeM","Marley",v1.getCognomeM());
	}

	@Test
	public void testGetVisitaSvolta() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals(false, v1.getVisitaSvolta());
	}

	@Test
	public void testSetVisitaSvolta() 
	{
		Visite v1=new Visite();
		v1.setVisitaSvolta(false);
		assertEquals("setVisitaSvolta",false,v1.getVisitaSvolta());
	}

	@Test
	public void testGetDataOra() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		assertEquals(dataOra, v1.getDataOra());
	}

	@Test
	public void testSetDataOra() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1=new Visite();
		v1.setDataOra(dataOra);
		assertEquals("setDataOra",dataOra, v1.getDataOra());
	}

	@Test
	public void testToString() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Visite v1 = new Visite(1,"Davide","Carizzoni","Bob","Marley",dataOra);
		
		String string = "1/ Nome e cognome del paziente: Davide Carizzoni/ Nome e cognome del medico: Bob Marley/ Data e ora della visita: "+v1.getDataOra()+".";
		assertEquals("ToString ", string, v1.toString());	
	}

}
