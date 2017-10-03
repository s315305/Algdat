import java.util.*;

/* Andreas Vestøl Løvsletten 
 * s315305 
 * DATS2300
 */

public class oblig_del2 {
	
	public static void main(String[] args)
	{
		int[] b = {2,5,7,8,11,12};
		System.out.println(Arrays.toString(sumx(b,20)));
		
	}
	
	// Oppgave 8
	public static void tidSorteringer(int[] a)
	{
		long tidu = System.currentTimeMillis();																						
		utvalgssortering(a);																																	
		tidu = System.currentTimeMillis() - tidu;
		System.out.println("Utvalgssortering: " + tidu + " ms");								// Utvalgssortering: 977 ms
		
		long tidi = System.currentTimeMillis();
		innsettingssortering(a);
		tidi = System.currentTimeMillis() - tidi;
		System.out.println("Innsettingssortering: " + tidi + " ms");						// Innsettingssortering: 2 ms
		
		long tidk = System.currentTimeMillis();
		kvikksortering(a);
		tidk = System.currentTimeMillis() - tidk;
		System.out.println("Kvikksortering: " + tidk + " ms");									// Kvikksortering: 4 ms
		
		long tidf = System.currentTimeMillis();
		flettesortering(a);
		tidf = System.currentTimeMillis() - tidf;
		System.out.println("Flettesortering: " + tidf + " ms");									// Flettesortering: 2 ms
	}
	
	//Oppgave 9
	public static int[] sumx(int[] a, int x)
	{
		for (int i = 1; i < a.length; i++)
		if ( a[i-1] > a[i] ) throw new IllegalStateException("tabellen er ikke sortert!");
		
		int[] b = new int[2];
		
		for (int j = 0; j < a.length; j++)
		{	
			for (int i = 1; i < a.length; i++)
			{
				if (a[j] + a[i] == x)
				{
					b[0] = a[j];
					b[1] = a[i];
					return b;
				}
			}
		}	
		return b;
	}
	
	//// hjelpe-metoder ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void bytt(int[] a, int i, int j)	
	{
	    int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}
	
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
	
	public static void utvalgssortering(int[] a)
  {
    for (int i = 0; i < a.length - 1; i++)
      bytt(a, i, min(a, i, a.length));  
  }
	
  public static void innsettingssortering(int[] a)
  {
    for (int i = 1; i < a.length; i++)  // starter med i = 1
    {
      int temp = a[i];  // hjelpevariabel
      for (int j = i - 1; j >= 0 && temp < a[j]; j--) bytt(a, j, j + 1);
    }
  }
  
  public static void fratilKontroll(int tablengde, int fra, int til)
  {
    if (fra < 0)                                  // fra er negativ
      throw new ArrayIndexOutOfBoundsException
        ("fra(" + fra + ") er negativ!");

    if (til > tablengde)                          // til er utenfor tabellen
      throw new ArrayIndexOutOfBoundsException
        ("til(" + til + ") > tablengde(" + tablengde + ")");

    if (fra > til)                                // fra er større enn til
      throw new IllegalArgumentException
        ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
  }
  
  private static int parter0(int[] a, int v, int h, int skilleverdi)
  {
    while (true)                                  // stopper når v > h
    {
      while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
      while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h      

      if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
      else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
    }
  }
  
  private static int sParter0(int[] a, int v, int h, int indeks)
  { 
    bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
    int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
    bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
    return pos;                   // returnerer posisjonen til skilleverdien
  }
  
  private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
  {
    if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
    int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
    kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
    kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
  }

  public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
  {
    fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
    kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
  }

  public static void kvikksortering(int[] a)   // sorterer hele tabellen
  {
    kvikksortering0(a, 0, a.length - 1);
  }
  
  private static void flett(int[] a, int[] b, int fra, int m, int til)
  {
    int n = m - fra;                // antall elementer i a[fra:m>
    System.arraycopy(a,fra,b,0,n);  // kopierer a[fra:m> over i b[0:n>

    int i = 0, j = m, k = fra;      // løkkeST0r og indekser

    while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
    {                               // legger resultatet i a[fra:til>
      a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
    }

    while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
  }
  
  private static void flettesortering(int[] a, int[] b, int fra, int til)
  {
    if (til - fra <= 1) return;   // a[fra:til> har maks ett element
    int m = (fra + til)/2;        // midt mellom fra og til

    flettesortering(a,b,fra,m);   // sorterer a[fra:m>
    flettesortering(a,b,m,til);   // sorterer a[m:til>

    if (a[m-1] > a[m]) flett(a,b,fra,m,til);  // fletter a[fra:m> og a[m:til>
  }
  
  public static void flettesortering(int[] a)
  {
    int[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
    flettesortering(a,b,0,a.length);          // kaller metoden over
  }
  
  public static int[] randPerm(int n)  				// en effektiv versjon
	{
	    Random r = new Random();         				// en randomgenerator
	    int[] a = new int[n];            				// en tabell med plass til n tall

	    Arrays.setAll(a, i -> i + 1);    				// legger inn tallene 1, 2, . , n

	    for (int k = n - 1; k > 0; k--)  				// løkke som går n - 1 ganger
	    {
	      int i = r.nextInt(k+1);        				// en tilfeldig tall fra 0 til k
	      bytt(a,k,i);                   				// bytter om
	    }

	    return a;                        				// permutasjonen returneres
	}

}
