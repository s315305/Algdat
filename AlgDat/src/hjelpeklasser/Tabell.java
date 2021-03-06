package hjelpeklasser;

import java.util.*;

public class Tabell 									// Samleklasse for tabellmetoder
{
	private Tabell() {}									// privat standardkonstrukt�r - hindrer instansiering
	
	// metoden bytt //////////////////////////////////////////////////////////////////////////////////////////
	public static void bytt(int[] a, int i, int j)	
	{
	    int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}
	
	// metoden randPerm ///////////////////////////////////////////////////////////////////////////////////////
	public static int[] randPerm(int n)  				// en effektiv versjon
	{
	    Random r = new Random();         				// en randomgenerator
	    int[] a = new int[n];            				// en tabell med plass til n tall

	    Arrays.setAll(a, i -> i + 1);    				// legger inn tallene 1, 2, . , n

	    for (int k = n - 1; k > 0; k--)  				// l�kke som g�r n - 1 ganger
	    {
	      int i = r.nextInt(k+1);        				// en tilfeldig tall fra 0 til k
	      bytt(a,k,i);                   				// bytter om
	    }

	    return a;                        				// permutasjonen returneres
	}
	
	// metoden randPerm for tabeller //////////////////////////////////////////////////////////////////////////
	
	public static void randPerm(int[] a)  				// stokker om a
	{
	   Random r = new Random();     					// en randomgenerator

	   for (int k = a.length - 1; k > 0; k--)
	   {
	     int i = r.nextInt(k + 1);  					// tilfeldig tall fra [0,k]
	     bytt(a,k,i);
	   }
	}
	
	// metoden maks med fra og til ///////////////////////////////////////////////////////////////////////////
	public static int maks(int[] a, int fra, int til)
	{
	    if (fra < 0 || til > a.length || fra >= til)
	    {
	      throw new IllegalArgumentException("Illegalt intervall!");
	    }

	    int m = fra;              						// indeks til st�rste verdi i a[fra:til>
	    int maksverdi = a[fra];   						// st�rste verdi i a[fra:til>

	    for (int i = fra + 1; i < til; i++)
	    {
	      if (a[i] > maksverdi)
	      {
	        m = i;                						// indeks til st�rste verdi oppdateres
	        maksverdi = a[m];     						// st�rste verdi oppdateres
	      }
	    }

	    return m;  // posisjonen til st�rste verdi i a[fra:til>
	}
	
	// metoden maks //////////////////////////////////////////////////////////////////////////////////////////
	public static int maks(int[] a)  					// bruker hele tabellen
	{
	    return maks(a,0,a.length);     					// kaller metoden over
	}
	
	// metoden min //////////////////////////////////////////////////////////////////////////////////////////
	public static int min(int[] a, int fra, int til)
	{
	    if (fra < 0 || til > a.length || fra >= til)
	      throw new IllegalArgumentException("Illegalt intervall!");

	    int m = fra;             						// indeks til minste verdi i a[fra:til>
	    int minverdi = a[fra];  						// minste verdi i a[fra:til>

	    for (int i = fra + 1; i < til; i++) if (a[i] < minverdi)
	    {
	      m = i;               							// indeks til minste verdi oppdateres
	      minverdi = a[m];    							// minste verdi oppdateres
	    }

	    return m;  										// posisjonen til minste verdi i a[fra:til>
	}

	// metoden min for hele tabellen //////////////////////////////////////////////////////////////////////////////////////////////////
	public static int min(int[] a)  					// bruker hele tabellen
	{
	    return min(a,0,a.length);  						// kaller metoden over
	}
	
	// metoden bytt for char /////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void bytt(char[] c, int i, int j)
	{
		char temp = c[i]; c[i] = c[j]; c[j] = temp;
	}
	
	// metoden fratilKontroll //////////////////////////////////////////////////////////////////////////////////////////////////
	public static void fratilKontroll(int tablengde, int fra, int til)
	{
	    if (fra < 0)                                  // fra er negativ
	      throw new ArrayIndexOutOfBoundsException
	        ("fra(" + fra + ") er negativ!");

	    if (til > tablengde)                          // til er utenfor tabellen
	      throw new ArrayIndexOutOfBoundsException
	        ("til(" + til + ") > tablengde(" + tablengde + ")");

	    if (fra > til)                                // fra er st�rre enn til
	      throw new IllegalArgumentException
	        ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
	}
	
	// metoden skriv //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void skriv(int[] a, int fra, int til)
	{
		fratilKontroll(a.length, fra, til);
		if (til - fra > 0) System.out.print(a[fra]);
		for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);	
	}
	
	// metoden skriv ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void skriv(int[] a)
	{
		skriv(a, 0, a.length);
	}
	
}