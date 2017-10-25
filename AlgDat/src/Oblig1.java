
import java.util.*;

/* Andreas Vestøl Løvsletten 
 * s315305 
 * DATS2300
 */
public class Oblig1 {
	
	// Oppgave 1
	
	public static int min(int[] a)
	{	
		if ( a.length < 1 ) throw new java.util.NoSuchElementException("Tabellen er tom!");
		
			for (int i = 1; i < a.length; i++)
			{
				int j = i + 1;
					
					if (a[a.length-i] < a[a.length-j])
					{
						int temp = a[a.length-i];
						a[a.length-i] = a[a.length-j];
						a[a.length-j] = temp;
					}
			}
			return a[0];
	}
	
	/* Hvor mange sammenligninger av tabellverdier blir det (som funksjon av n)?
	 *
	 * I dette tilfellet er det bare n - 1 sammenligninger. 
	 */
	
	// Metoden ombyttinger:
	
	public static int ombyttinger(int[] a)
	{
		if ( a.length < 1 ) throw new java.util.NoSuchElementException("Tabellen er tom!");
			
		int ombytt = 0;
		
			for (int i = 1; i < a.length; i++)
			{
				int j = i + 1;
			
					if (a[a.length-i] < a[a.length-j])
					{
						int temp = a[a.length-i];
						a[a.length-i] = a[a.length-j]; ombytt++;
						a[a.length-j] = temp;
					}
			}
			return ombytt;
	}
	
	/* Kan du på grunnlag av dette si om metoden min er bedre (eller dårligere) enn de min-metodene vi har sett tidligere?
	 * 
	 * Denne min metoden er bedre, da den kun sorterer slik at minste tall er først og tar ikke hensyn til om resten av tallene er sortert.
	 */
	
	// Oppgave 2:
	
	public static int modus1(int[] a)
	{
		if ( a.length == 0 ) throw new IllegalStateException("tabellen er tom!");												// tabellen kan ikke være tom
		for (int i = 1; i < a.length; i++)
		if ( a[i-1] > a[i] ) throw new IllegalStateException("tabellen er ikke sortert stigende!");	// tabellen må være stigende
			
			int modus = a[0];
			int maksTeller = 0;
				
				for (int i = 0; i < a.length; i++)
				{
					int verdi = a[i];
					int teller = 1;
					
						for (int j = 0; j < a.length; j++)
						{
							if (a[j] == verdi) teller ++;
								if (teller > maksTeller)
								{
									modus = verdi;
									maksTeller = teller;
								}
						}
				}
				return modus;
	}

	// Oppgave 3:
	
	public static int modus2(int[] a)
	{
		if (a.length == 0) throw new IllegalStateException("tabellen er tom!");
			
			int modus = a[0];
			int maksTeller = 0;
				
				for (int i = 0; i < a.length; i++)
				{
					int verdi = a[i];
					int teller = 1;
					
						for (int j = 0; j < a.length; j++)
						{
							if (a[j] == verdi) teller++;
							if (teller > maksTeller)
							{
								modus = verdi;
								maksTeller = teller;
							}
						}
				}
				return modus;	
	}
	
	// Oppgave 4:
	
	public static void delsortering(int[] a)
	{
		int temp = 0;
		int v = 0;
		int h = a.length-1;

		for (int i = 0; i < a.length; i++)																			// sorterer partall på vs og oddetall på hs
		{
			while (v < h && a[v] % 2 != 0) v++;																		// øker v hvis oddetall på venstre side
			while (v < h && a[h] % 2 == 0) h--;																		// minsker h hvis partall på høyre side
				
				if (a[v] % 2 == 0 && a[h] % 2 != 0)																	// bytter a[v] med a[h] dersom a[v] er partall og a[h] er oddetall
				{
					temp = a[v];
					a[v] = a[h];
					a[h] = temp;
				}
		}
		for (int j = 0; j < a.length; j++)																			
		{
			for (int i = 1; i < a.length; i++)
			{
				if (a[i-1] > a[i] && a[i] % 2 != 0 && a[i-1] % 2 != 0)							// sorterer oddetall stigende
				{
					temp = a[i-1];
					a[i-1] = a[i];
					a[i] = temp;
				}
				else if (a[i-1] > a[i] && a[i] % 2 == 0 && a[i-1] % 2 == 0)					// sorterer partall stigende
				{
					temp = a[i-1];
					a[i-1] = a[i];
					a[i] = temp;
				}
			}
		}
	}
	
	// Oppgave 5:
	public static void rotasjon(char [] a)
	{
		if (a.length <= 1) return;
		
		char første = a[a.length -1];
		
		for (int i = a.length-1; i >= 1 ; i--) a[i] = a[i-1];
		
		a[0] = første;
	}
	
	// Oppgave 6: Lager en metode for største felles divisor først
	public static int gcd(int a, int b)
	{
		return b == 0 ? a: gcd(b, a % b);
	}
	
	public static void rotasjon(char[] a, int k)
	{
		int n = a.length; if (n < 2) return;
		if ((k %= n) < 0) k += n;
		
		int s = gcd(n,k);
		
		for (int m = 0;  m < s; m++)
		{
			char verdi = a[m];
			
			for (int i = m - k, j = m; i != m; i -= k)
			{
				if (i < 0) i += n;
				a[j] = a[i]; j = i;
			}
			
			a[m + k] = verdi;
		}
	}
	
	// Oppgave 7a:
	public static String flett(String s, String t)
	{
		int k = Math.min(s.length(), t.length());
		StringBuilder a = new StringBuilder();
		
		for (int i = 0; i < k; i++)
		{
			a.append(s.charAt(i)).append(t.charAt(i));
		}
		
		a.append(s.substring(k)).append(t.substring(k));
		
		return a.toString();
	}
	
	// 7b:
	public static String flett(String... s)
	{
		StringBuilder t = new StringBuilder();
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < s.length; j++)
			{
				if (s[j].length() < i);
				if (s[j].length() > i) t.append(s[j].charAt(i));
			}
		}
		return t.toString();
	}
	
	public static void tidSorteringer(int[] a)
	{
		
		
	}
	
	public static void main (String[] args)
	{	
		String a = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
		System.out.println(a);
		
		
	}
}


