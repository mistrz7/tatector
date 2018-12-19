package pl.tmobile.dn.tactor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pl.tmobile.dn.tatector.PlikObsluga;

public class PlikObslugaTest
{
	PlikObsluga plikObsluga; 
	
	@Before
	public void init()
	{
		plikObsluga=new PlikObsluga();
	}
	
	@Test
	public void data()
	{
		assertEquals("date", plikObsluga.okreslTyp("2018-01-01", "yyyy-MM-dd"));
	}
	
	@Test
	public void data2()
	{
		assertEquals("date", plikObsluga.okreslTyp("2018/01/01", "yyyy/MM/dd"));
	}
	
	@Test
	public void zmiennnoPrzecinkowa()
	{
		assertEquals("double", plikObsluga.okreslTyp("12.12", "yyyy/MM/dd"));
	}
	
	@Test
	public void zmiennnoPrzecinkowa2()
	{
		assertEquals("double", plikObsluga.okreslTyp("12.1214", "yyyy/MM/dd"));
	}
	
	@Test
	public void zmiennnoPrzecinkowa3()
	{
		assertEquals("double", plikObsluga.okreslTyp("12,1214", "yyyy/MM/dd"));
	}

	@Test
	public void liczba()
	{
		assertEquals("int", plikObsluga.okreslTyp("1234", "yyyy/MM/dd"));
	}
	
	@Test
	public void liczba2()
	{
		assertEquals("int", plikObsluga.okreslTyp("99999", "yyyy/MM/dd"));
	}
	
	@Test
	public void tekst()
	{
		assertEquals("varchar(4)", plikObsluga.okreslTyp("Milu", "yyyy/MM/dd"));
	}

	@Test
	public void tekst2()
	{
		assertEquals("varchar(32)", plikObsluga.okreslTyp("konstantynopolitańczykowianeczka", "yyyy/MM/dd"));
	}
}
