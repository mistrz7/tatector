package pl.tmobile.dn.tatector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlikObsluga
{

	public List<List<String>> wczytajPlik(String sciezka, String delimiter)
	{
		List<List<String>> wynik=new ArrayList();
		List<String> wiersz;
		String linia;
		try
		{
			Scanner scanner=new Scanner(new File(sciezka));
			while(scanner.hasNextLine())
			{
				linia=scanner.nextLine();
				String[] split = linia.split(delimiter);
				wiersz=new ArrayList();
				for (String string : split)
				{
					wiersz.add(string);
				}

				wynik.add(wiersz);
			}
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return wynik;
	}

	/**
	 * 
	 * @param plik
	 * @param skanowanychLini
	 * @param tworzycDdl
	 */
	public List<String> znajdzTypyPol(List<List<String>> plik, Integer skanowanychLini, Boolean tworzycDdl)
	{
		int i=0;
		int j=0;
		
		List<String> wynik=new ArrayList<>();
		
		//przekrec plik
		for (List<String> list : plik)
		{
			i++;
			
			//pomijam pierwsza linie
			if(i==1 && tworzycDdl) continue;
			
			j=0;
			//analizuje kolumny
			for (String komorka : list)
			{
				if(wynik.size()==j) wynik.add(j, String.valueOf(komorka.length()));
				else
				{
					if(Integer.valueOf(komorka.length())>Integer.valueOf(wynik.get(j)))
					{
						wynik.set(j, String.valueOf(komorka.length()));
					}
				}
				j++;
			}
			
			System.out.println(list);
		}
		
		return wynik;
	}
	
}