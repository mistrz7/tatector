package pl.smilu.tatector;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * zadaniem programu jest okreslnie dla podanego pliku csv jak najdokladniejszego typu pol i zasugerowanie tabeli dll na podstawie pierwszego wiersza
 * parametry:
 * - sciezka do pliku csv
 * - delimiter
 * - ilosc analizowanych wierszy (niewymagane)
 * - czy tworzyc ddl na podstawie pierwszego wiersza (niewymagane)
 */
public class Main
{
	private static Logger logger = Logger.getLogger(Main.class);
			
	public static void main(String[] args)
	{
		logger.info("start");
		
		Parametry parametry=new Parametry();
		if(!parametry.utworzParametry(args))
		{
			logger.info("blad okreslania parametrow wejsciowych");
		}
		
		logger.info("plik="+parametry.getSciezka());
		logger.info("delimiter="+parametry.getDelimiter());
		logger.info("ilosc skanowanych linii="+parametry.getSkanowanychLini());
		logger.info("czy bedzie tworzony ddl="+parametry.getNazwyWPierwszejLinii());
		
		PlikObsluga plikObsluga=new PlikObsluga();
		List<List<String>> plik=plikObsluga.wczytajPlik(parametry.getSciezka(), parametry.getDelimiter());
		logger.info("wczytalem pliki, linii="+plik.size());
		
		logger.info("start analizy");
		List<String> typyPol = plikObsluga.znajdzTypyPol(plik, parametry.getSkanowanychLini(), parametry.getNazwyWPierwszejLinii(), parametry.getFormatDate());

		logger.info("plik przeanaliozowany, oto wynik:");
		plikObsluga.pokazWynik(plik, typyPol, parametry.getNazwyWPierwszejLinii());
		
		logger.info("koniec");
	}

}
