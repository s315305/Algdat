/* Andreas Vestøl Løvsletten 
 * s315305 
 * DATS2300
 */
public class Oblig1 {
	
	// Oppgave 1
	
	public static int min(int[] a)
	{
		if ( a.length < 1 )
			throw new java.util.NoSuchElementException("Tabellen er tom!");
		
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
		int ombytt = 0;
		
		if ( a.length < 1 )
			throw new java.util.NoSuchElementException("Tabellen er tom!");
		
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
		for (int i = 1; i < a.length; i++)
		{
			if ( a.length < 1 || a[i-1] > a[i])
				throw new IllegalStateException("a er en ugyldig tabell!");
		}	
		int modus = a[0];
		int maksteller = 0;
		
		for (int j = 0; j < a.length; j++)
		{
			int verdi = a[j];
			int teller = 1;
			
			for (int k = 0; k < a.length; k++)
			{
				if (a[k] == verdi) teller++;
				if (teller > maksteller)
				{
					modus = verdi;
					maksteller = teller;
				}
			}
		}
		return modus;
	}

	
	public static void main (String[] args){
		
		int[] b = {0,0,0,0,1,1,2,2,3,3,3};
		
		System.out.println(modus1(b));
	}
}


