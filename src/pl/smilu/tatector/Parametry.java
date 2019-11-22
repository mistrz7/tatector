package pl.smilu.tatector;

public class Parametry
{
	private String sciezka;
	private String delimiter;
	private String formatDate;
	private Integer skanowanychLini;
	private Boolean nazwyWPierwszejLinii;
	
	
	
	/**
	 * @param sciezka
	 * @param delimiter
	 * @param formatDate
	 * @param skanowanychLini
	 * @param nazwyWPierwszejLinii
	 */
	public Parametry()
	{
		super();
		this.delimiter = ";";
		this.formatDate = "yyyy-MM-dd";
		this.skanowanychLini = 10000;
		this.nazwyWPierwszejLinii = true;
	}

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

	public Boolean getNazwyWPierwszejLinii()
	{
		return nazwyWPierwszejLinii;
	}

	public void setNazwyWPierwszejLinii(Boolean nazwyWPierwszejLinii)
	{
		this.nazwyWPierwszejLinii = nazwyWPierwszejLinii;
	}

	public String getFormatDate()
	{
		return formatDate;
	}

	public void setFormatDate(String formatDate)
	{
		this.formatDate = formatDate;
	}
}
