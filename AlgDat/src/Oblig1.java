import java.util.Arrays;

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
	
	// Oppgave 6:
	public static void rotasjon(char[] a, int k)
	{
		if (a.length <= 1) return;
		if ((k %= a.length) < 0) k += a.length;
		
	
	}

	public static void main (String[] args){
		
		char[] b = {'A','B','C','D','E','F','G','H','I','J'};
		rotasjon(b, 5);
		System.out.println(Arrays.toString(b));
	}
}


