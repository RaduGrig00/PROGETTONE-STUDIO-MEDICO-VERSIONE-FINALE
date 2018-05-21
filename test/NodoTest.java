import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest 
{
	
	Visite v1 = new Visite();
	Visite v2 = new Visite();

	@Test
	public void testNodo() throws Exception 
	{
		Nodo nodo = new Nodo(v1);
		Nodo nodo2 = new Nodo(v1);		
		
		assertEquals(nodo.getInfo(), v1);
		assertEquals(nodo.getLink(), null);
		nodo.setInfo(v2);
		nodo.setLink(nodo2);
		assertEquals(nodo.getInfo(), v2);
		assertEquals(nodo.getLink(), nodo2);
	}

	@Test
	public void testGetInfo() throws Exception 
	{
		Nodo nodo = new Nodo(v1);
		assertEquals(nodo.getInfo(), v1);
		nodo.setInfo(v2);
		assertEquals(nodo.getInfo(), v2);
	}

	@Test
	public void testGetLink() throws Exception 
	{
		Nodo nodo = new Nodo(v1);
		Nodo nodo2 = new Nodo(v1);
		assertEquals(nodo.getLink(), null);
		nodo.setLink(nodo2);
		assertEquals(nodo.getLink(), nodo2);
	}
	
	@Test
	public void testSetLink() 
	{
		Visite v1=new Visite();
		Visite v2=new Visite();
		Nodo n1=new Nodo(v1);
		Nodo n2=new Nodo(v2);
		n1.setLink(n2);
		assertTrue("setLink",n1.getInfo().equals(v1)&&n1.getLink()==n2);
	}

	@Test
	public void testSetInfo() 
	{
		Visite v1=new Visite();
		Visite v2=new Visite();
		Nodo n=new Nodo(v1);
		n.setInfo(v2);
		assertTrue("setInfo",n.getInfo().equals(v2)&&n.getLink()==null);
	}


}
