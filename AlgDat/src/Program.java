import hjelpeklasser.Tabell;

public class Program 
{
	public static void main(String... args)				// hovedprogram
	{
		
		int[] a = Tabell.randPerm(20);					// en tilfeldig tabell
		for (int k : a) System.out.print(k + " ");		// skriver ut a
		
		int m = Tabell.maks(a);							// finner posisjonen til st�rste verdi
		
		System.out.println("\nSt�rste verdi ligger p� plass " + m);
		
	}
	
}
