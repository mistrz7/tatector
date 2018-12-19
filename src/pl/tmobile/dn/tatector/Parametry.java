package pl.tmobile.dn.tatector;

public class Parametry
{
	private String sciezka;
	private String delimiter;
	private Integer skanowanychLini;
	private Boolean tworzycDdl;
	
	/**
	 * 
	 * @param args
	 * @return
	 */
	
	//TODO, skanowanychLinii i tworzyc ddl sa opcjonalne i powinny byc szczytywane z wartosci domyslych jesli nie sa podane. Jesli nie uda sie 
	//okreslic parametrow to zwroc blad 
	public boolean utworzParametry(String[] args)
	{
		sciezka=args[0];
		delimiter=args[1];
		skanowanychLini=Integer.valueOf(args[2]);
		tworzycDdl=Boolean.valueOf(args[3]);
		
		return true;
	}

	public String getSciezka()
	{
		return sciezka;
	}

	public void setSciezka(String sciezka)
	{
		this.sciezka = sciezka;
	}

	public String getDelimiter()
	{
		return delimiter;
	}

	public void setDelimiter(String delimiter)
	{
		this.delimiter = delimiter;
	}

	public Integer getSkanowanychLini()
	{
		return skanowanychLini;
	}

	public void setSkanowanychLini(Integer skanowanychLini)
	{
		this.skanowanychLini = skanowanychLini;
	}

	public Boolean getTworzycDdl()
	{
		return tworzycDdl;
	}

	public void setTworzycDdl(Boolean tworzycDdl)
	{
		this.tworzycDdl = tworzycDdl;
	}
}
