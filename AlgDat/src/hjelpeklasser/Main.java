package hjelpeklasser;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

	public static void main (String[] args)
	{
		Integer[] a = {8,2,10,1,6,9,14,4,7,12,15,3,5,11,13};      // en tabell

	  SBinTre<Integer> tre1 = SBinTre.sbintre(Stream.of(a));    // et binært søketre

	  Comparator<Integer> c = Comparator.reverseOrder();        // omvendtkomparator
	  SBinTre<Integer> tre2 = SBinTre.sbintre(Stream.of(a),c);  // speilvendt tre
	  System.out.println(tre1 + "\n" + tre2);
	}
}
