package pl.smilu.tatector;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
	 * @param string 
	 */
	public List<String> znajdzTypyPol(List<List<String>> plik, Integer skanowanychLini, Boolean tworzycDdl, String formatDate)
	{
		int i=0;
		int j=0;
		
		List<String> wynik=new ArrayList<>();
		String nowyTyp;
		String staryTyp;
		
		//przekrec plik
		for (List<String> list : plik)
		{
			i++;
			
			if(i>skanowanychLini) break;
			
			//pomijam pierwsza linie
			if(i==1 && tworzycDdl) continue;
			
			j=0;
			//analizuje kolumny
			for (String komorka : list)
			{
				nowyTyp=okreslTyp(komorka, formatDate);
				
				if(wynik.size()==j) 
				{
					wynik.add(j, nowyTyp);
				}
				else
				{
					staryTyp=wynik.get(j);
					
					//nie rownaja sie wiec trzeba podmienic
					if(!nowyTyp.equals(staryTyp))
					{
						if(!nowyTyp.equals("unknown") && staryTyp.equals("unknown"))
						{
							wynik.set(j, nowyTyp);
						}
						
						//jesli by int, double lub date a teraz jest char to char
						if(nowyTyp.startsWith("varchar") && staryTyp.equals("date") ||  staryTyp.equals("int") ||  staryTyp.equals("double"))
						{
							wynik.set(j, nowyTyp);
						}
						
						//jesli by int a teraz double to double
						if(nowyTyp.equals("double") && staryTyp.equals("int"))
						{
							wynik.set(j, "double");
						}
						if(nowyTyp.startsWith("varchar") && staryTyp.startsWith("varchar") 
								&& Integer.valueOf(nowyTyp.substring(8, nowyTyp.length()-1))>Integer.valueOf(staryTyp.substring(8, staryTyp.length()-1)))
						{
							wynik.set(j, nowyTyp);
						}
					}
				}
				j++;
			}
		}
		
		return wynik;
	}
	
	/**
	 * Okreslam typ tekstu w kolejnosci: date, deciaml, integer, char(X) 
	 * @param tekst
	 * @return typ zmiennej
	 */
	public String okreslTyp(String tekst, String formatDate)
	{
		//czy data
		try
		{
			if(tekst.trim().length()==formatDate.trim().length())
			{
				new SimpleDateFormat(formatDate).parse(tekst);
				return "date";
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}

		//czy int
		try
		{
			Integer.valueOf(tekst);
			return "int";
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		//czy double
		try
		{
			Double.valueOf(tekst.replace(",", "."));
			return "double";
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}

		//pozostal string
		if(tekst.length()>0)
		{
			return "varchar("+tekst.length()+")";
		}
		
		return "unknown";
		
	}

	public void pokazWynik(List<List<String>> plik, List<String> typyPol, Boolean tworzycDdl)
	{
		int i=0;
		for (String string : typyPol)
		{
			if(tworzycDdl)
			{
				if(plik.get(0).size()>i)
				{
					System.out.print(plik.get(0).get(i).toLowerCase()+" ");
				}
			}
			System.out.println(string+", ");
			
			i++;
		}
	}
	
}