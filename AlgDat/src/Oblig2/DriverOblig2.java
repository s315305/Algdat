package Oblig2;

public class DriverOblig2 
{
	
	public static void main (String[] args)
	{
		String[] s = {"Ole", null, "Per", "Kari", null};
		Liste<String> liste = new DobbeltLenketListe<>(s);
		System.out.println(liste.antall() + " " + liste.tom());
	}

}
