/* Andreas Vestøl Løvsletten 
 * s315305 
 * DATS2300
 */
public class Oblig1 {
	
	// Oppgave 1
	
	public static int min(int[] a){
		
		if ( a.length < 1 )
			throw new java.util.NoSuchElementException("Tabellen er tom!");
		
		int n = a.length;							
		int k;
		
		for (int m = n; m >= 0; m--){
			for (int i = 0; i < n - 1; i++){
				k = i + 1;
				
				if(a[i] > a[k]){
					int t;
					t = a[i];
					a[i] = a[k];
					a[k] = t;
				}
			}
		}
		return a[0];
	}
	
	/* Hvor mange sammenligninger av tabellverdier blir det (som funksjon av n)?
	 * Da dette er en boblesortering vil antall sammenligninger i verste tilfelle
	 * være n(n-1)/2 sammenligninger.
	 */
	
	public static int ombyttinger(int[] a){
		
		int o = 0;
		
		int n = a.length;							
		int k;
		
		for (int m = n; m >= 0; m--){
			for (int i = 0; i < n - 1; i++){
				k = i + 1;
				
				if(a[i] > a[k]){
					int t;
					t = a[i];
					a[i] = a[k]; o++;
					a[k] = t;
				}
			}
		}
		return o;
	}
	
	public static void main (String[] args){
		
		int[] b = {4,6,2,1,3};
		
		System.out.println(ombyttinger(b));
	}
}
