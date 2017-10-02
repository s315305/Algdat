////// Testprogram for Oblig 1 - 2017 ////////////////////////

/*
Testprogrammet har en main-metode som tester metodene i de 10 oppgavene.
Som utgangspunkt er metodekallene kommentert vekk. Her må en passe på å bruke nøyaktig samme navn på  metodene som det er bedt om i oppgaveteksten.

Når en mener at en oppgave/metode er løst, blir en først teste med egne tester. Når en så tror at koden er feilfri, kan testprogrammet brukes ved at kommentartegnet foran metodekallet tas vekk. Testprogrammet må gi 0 feil før Oblig 1 sendes inn!
*/

///// Oppdatert 9. september 2016 ///////////////

import java.util.*;

public class Oblig1Test
{
  public static void main(String[] args)
  {
    int antallFeil = 0;

    //antallFeil += oppgave1();
    //antallFeil += oppgave2();
    //antallFeil += oppgave3();
    //antallFeil += oppgave4();
    //antallFeil += oppgave5();
    //antallFeil += oppgave6();
    //antallFeil += oppgave7();
    
    if (antallFeil == 0)
    {
      System.out.println("Gratulerer!! Du passerte testen!");
    }
    else
    {
      System.out.println("Må forbedres! Du har minst "
        + antallFeil + " feil eller svakheter!");
    }
  }

  ///// Oppgave 1 //////////////////////////////////////

  public static int oppgave1()
  {
    int antallFeil = 0;

    boolean unntak = false;
    int[] tom = {};
    try
    {
      Oblig1.min(tom);  // kaller min-metoden
    }
    catch (Exception e)
    {
      unntak = true;
      if (!(e instanceof java.util.NoSuchElementException))
      {
        System.out.println("Opgave 1: a) Feil unntak for en tom tabell!");
        antallFeil++;
      }
    }

    if (!unntak)
    {
      System.out.println("Opgave 1: b) Kast unntak for en tom tabell!");
      antallFeil++;
    }

    int[] a = {3};
    int[] b = {5,2,8,4,7,6};
    int[] c = {5,4,3,2,1};
    int[] d = {1,2,3,4,5};
    if (Oblig1.min(a) != 3 || Oblig1.min(b) != 2 ||
        Oblig1.min(c) != 1 || Oblig1.min(d) != 1)
    {
      System.out.println("Oppgave 1: c) Min-metoden: Feil resultat!");
      antallFeil++;
    }

    int[] e = {8,9,2,10,5,6,1,7,3,4};
    int[] f = {1,8,9,2,10,5,6,3,7,4};

    Oblig1.min(e);
    if(!Arrays.equals(e,f))
    {
      System.out.println("Oppgave 1: d) Min-metoden: feil i ombyttingene!");
      antallFeil++;
    }

    a = new int[] {6,5,4,3,2,1};
    b = new int[] {1,2,3,4,5};
    c = new int[] {4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
    d = new int[] {2, 5, 8, 4, 3, 10, 1, 7, 6, 9};

    if (Oblig1.ombyttinger(a) != 5 || Oblig1.ombyttinger(b) != 0
      || Oblig1.ombyttinger(c) != 8 || Oblig1.ombyttinger(d) != 7)
    {
      System.out.println("Oppgave 1: e) Feil opptelling i ombyttingsmetoden!");
      antallFeil++;
    }
    return antallFeil;
  }

///// Oppgave 2 //////////////////////////////////////

  public static int oppgave2()
  {
    int antallFeil = 0;

    int[] a = {};
    int[] b = {1};
    int[] c = {1,2,3,4,5,4};

    try
    {
      Oblig1.modus1(b);  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println
        ("Oppgave 2: a) Ikke unntak for tabell med 0 eller 1 verdi!");
      antallFeil++;
    }

    boolean unntak = false;

    try
    {
      Oblig1.modus1(a);  // kaller metoden
      Oblig1.modus1(c);  // kaller metoden
    }
    catch (Exception e)
    {
      unntak = true;
      if (!(e instanceof IllegalStateException))
      {
        System.out.println
          ("Oppgave 2: b) Feil unntak for en tom eller usortert tabell!");
        antallFeil++;
      }
    }

    if (!unntak)
    {
      System.out.println
        ("Oppgave 2: c) Kast et unntak for en tom eller usortert tabell!");
      antallFeil++;
    }

    int[] d = {1,1};
    int[] e = {1,2,3,4,5,6,7,7};
    int[] f = {1,1,2,2,2,3,4,4,5,6,6,6,6,7};

    if (Oblig1.modus1(b) != 1
        || Oblig1.modus1(d) != 1
        || Oblig1.modus1(e) != 7
        || Oblig1.modus1(f) != 6)
     {
       System.out.println("Oppgave 2: d) Metoden gir feil resultat!");
       antallFeil++;
     }
    return antallFeil;
  }

  ///// Oppgave 3 //////////////////////////////////////

  public static int oppgave3()
  {
    int antallFeil = 0;

    int[] a = {};   // skal kaste unntak her!
    int[] b = {1};  // skal ikke kaste unntak her!
    int[] c = {1,1};
    int[] d = {6,2,4,6,9,1,4,9,10};
    int[] dkopi = {6,2,4,6,9,1,4,9,10};
    int[] e = {5,4,3,2,1};
    int[] f = {1,2,2,2,2,2,3};

	try
    {
      Oblig1.modus2(a);  // kaller metoden
    }
    catch (Exception e1)
    {
      if (!(e1 instanceof IllegalStateException))
      {
      	System.out.println("Oppgave 3: a) Feil unntak for en tom tabell!");
      	antallFeil++;
      }	
    }

    try
    {
      Oblig1.modus2(b);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 3: b) Ikke unntak for tabell med 1 verdi!");
      antallFeil++;
    }

    if (Oblig1.modus2(b) != 1
        || Oblig1.modus2(c) != 1
        || Oblig1.modus2(d) != 6
        || Oblig1.modus2(e) != 5
        || Oblig1.modus2(f) != 2)
    {
      System.out.println("Oppgave 3: c) Metoden gir feil resultat!");
      antallFeil++;
    }

    if (!Arrays.equals(d,dkopi))
    {
      System.out.println("Oppgave 3: d) Metoden endrer tabellen!");
      antallFeil++;
    }

    return antallFeil;
  }

  ///// Oppgave 4 //////////////////////////////////////

  public static int oppgave4()
  {
    int antallFeil = 0;

    int[] a = {};   // skal ikke kaste unntak her!

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
       ("Oppgave 4: a) Ikke unntak for en tom tabell!");
      antallFeil++;
    }

    a = new int[] {5};
    int[] b = {5};

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 4: b) Skal ikke kastes unntak her!");
      antallFeil++;
    }

    if (!Arrays.equals(a,b))
    {
      System.out.println
        ("Oppgave 4: c) Metoden gjør feil for en tabell en verdi!");
      antallFeil++;
    }

    a = new int[] {4};
    b = new int[] {4};

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 4: d) Skal ikke kastes unntak her!");
      antallFeil++;
    }

    if (!Arrays.equals(a,b))
    {
      System.out.println
        ("Oppgave 4: e) Metoden gjør feil for en tabell en verdi!");
      antallFeil++;
    }

    a = new int[] {4,2,6,10,8};
    b = new int[] {2,4,6,8,10};

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 4: f) Det går galt hvis det kun er partall!");
      antallFeil++;
    }

    if (!Arrays.equals(a,b))
    {
      System.out.println
        ("Oppgave 4: g) Det blir feil hvis det kun er partall!");
      antallFeil++;
    }

    a = new int[] {9,5,3,1,7};
    b = new int[] {1,3,5,7,9};

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 4: h) Det går galt hvis det kun er oddetall!");
      antallFeil++;
    }

    if (!Arrays.equals(a,b))
    {
      System.out.println
        ("Oppgave 4: i) Det blir feil hvis det kun er oddetall!");
      antallFeil++;
    }

    a = new int[] {1,2,3,4,5,6};
    b = new int[] {1,3,5,2,4,6};
    boolean flere = true;

    do
    {
      int[] c = a.clone();
      Oblig1.delsortering(c);

      if (!Arrays.equals(c,b))
      {
        System.out.println
          ("Oppgave 4: j) Gitt tabell:     " + Arrays.toString(a));
        System.out.println
          ("              Metoden skal gi: " + Arrays.toString(b));
        System.out.println
          ("              Du fikk:         " + Arrays.toString(c));

        antallFeil++;
        break;
      }
    } while (nestePermutasjon(a));

    a = new int[] {-4,-1,3,0,2,-3,-2,4,1};
    b = new int[] {-3,-1,1,3,-4,-2,0,2,4};

    try
    {
      Oblig1.delsortering(a);  // kaller metoden
    }
    catch (Exception ex)
    {
      System.out.println
        ("Oppgave 4: k) Skal ikke kastes unntak her!");
      antallFeil++;
    }

    if (!Arrays.equals(a,b))
    {
      System.out.println
        ("Oppgave 4: l) Metoden gjør feil for negative verdier!");
      antallFeil++;
    }

    if (antallFeil == 0)
    {
      a = randPerm(100000);
      long tid = System.currentTimeMillis();
      Oblig1.delsortering(a);
      tid = System.currentTimeMillis() - tid;

      for (int i = 0; i < 50000; i++)
      {
        if (a[i] != 2*i + 1)
        {
          System.out.println
            ("Oppgave 4: m) Feil resultat for denne tabellen!");
          antallFeil++;
          break;
        }
      }

      for (int i = 50000; i < 100000; i++)
      {
        if (a[i] != 2*(i - 49999))
        {
          System.out.println
            ("Oppgave 4: n) Feil resultat for denne tabellen!");
          antallFeil++;
          break;
        }
      }

      if (tid > 100)
      {
        System.out.println
          ("Oppgave 4: o) Tid: " + tid + ". Metoden er for ineffektiv!");
        System.out.println
          ("              Hint: Bruk en partisjoneringsteknikk!");
        antallFeil++;
      }
    }

    return antallFeil;
  }

  ///// Oppgave 5 //////////////////////////////////////

  public static int oppgave5()
  {
    int antallFeil = 0;

    char[] a = {};

    try
    {
      Oblig1.rotasjon(a);  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println
        ("Oppgave 5: a) Skal ikke kaste unntak for en tom tabell!!");
        antallFeil++;
    }

    char[] b = {'A'};
    char[] b0 = {'A'};
    Oblig1.rotasjon(b);
    if (!Arrays.equals(b, b0))
    {
      System.out.println("Oppgave 5: b) Feil hvis tabellen har ett element!");
      antallFeil++;
    }

    char[] c = {'A','B'};
    char[] c0 = {'B','A'};
    Oblig1.rotasjon(c);
    if (!Arrays.equals(c, c0))
    {
      System.out.println("Oppgave 5: c) Feil hvis tabellen har to elementer!");
      antallFeil++;
    }

    char[] d = {'A','B','C','D','E','F','G','H','I','J'};
    char[] d0 = {'J','A','B','C','D','E','F','G','H','I'};

    Oblig1.rotasjon(d);
    if (!Arrays.equals(d, d0))
    {
      System.out.println("Oppgave 5: d) Feil hvis tabellen har flere elementer!");
      antallFeil++;
    }

    return antallFeil;
  }

  ///// Oppgave 6 //////////////////////////////////////

  public static int oppgave6()
  {
    int antallFeil = 0;

    char[] a = {};

    try
    {
      Oblig1.rotasjon(a,1);  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 6: a) Skal ikke kaste unntak for en tom tabell!!");
        antallFeil++;
    }

    char[] b = {'A'};
    char[] b0 = {'A'};
    Oblig1.rotasjon(b,0);
    if (!Arrays.equals(b, b0))
    {
      System.out.println("Oppgave 6: b) Feil hvis tabellen har ett element!");
      antallFeil++;
    }

    Oblig1.rotasjon(b,1);
    if (!Arrays.equals(b, b0))
    {
      System.out.println("Oppgave 6: c) Feil hvis tabellen har ett element!");
      antallFeil++;
    }

    Oblig1.rotasjon(b,-1);
    if (!Arrays.equals(b, b0))
    {
      System.out.println("Oppgave 6: d) Feil hvis tabellen har ett element!");
      antallFeil++;
    }

    char[] c = {'A','B'};
    char[] c0 = {'B','A'};
    Oblig1.rotasjon(c,1);

    if (!Arrays.equals(c, c0))
    {
      System.out.println("Oppgave 6: e) Feil hvis tabellen har to elementer!");
      antallFeil++;
    }

    c = new char[] {'A','B'};

    Oblig1.rotasjon(c,-1);
    if (!Arrays.equals(c, c0))
    {
      System.out.println("Oppgave 6: f) Feil hvis tabellen har to elementer!");
      antallFeil++;
    }

    char[] d = {'A','B','C','D','E','F','G','H','I','J'};
    char[] d0 = {'G','H','I','J','A','B','C','D','E','F'};

    Oblig1.rotasjon(d,4);
    if (!Arrays.equals(d, d0))
    {
      System.out.println("Oppgave 6: g) Feil hvis tabellen har flere elementer!");
      antallFeil++;
    }

    d = new char[]{'A','B','C','D','E','F','G','H','I','J'};
    Oblig1.rotasjon(d,-6);
    if (!Arrays.equals(d, d0))
    {
      System.out.println("Oppgave 6: h) Feil hvis tabellen har flere elementer!");
      antallFeil++;
    }

    char[] x = new char[100_000];
    long tid = System.currentTimeMillis();
    Oblig1.rotasjon(x,99_999);
    tid = System.currentTimeMillis() - tid;

    if (tid > 20)
    {
      System.out.println("Oppgave 6: i) Metoden "
        + "er for ineffektiv. må forbedres!");
      antallFeil++;
    }

    tid = System.currentTimeMillis();
    Oblig1.rotasjon(x,199_999);
    tid = System.currentTimeMillis() - tid;

    if (tid > 20)
    {
      System.out.println("Oppgave 6: j) Metoden "
        + "er for ineffektiv. må forbedres!");
      antallFeil++;
    }

    tid = System.currentTimeMillis();
    Oblig1.rotasjon(x,50_000);
    tid = System.currentTimeMillis() - tid;

    if (tid > 20)
    {
      System.out.println("Oppgave 6: k) Metoden "
        + "er for ineffektiv. må forbedres!");
      antallFeil++;
    }

    tid = System.currentTimeMillis();
    Oblig1.rotasjon(x,-40_000);
    tid = System.currentTimeMillis() - tid;

    if (tid > 20)
    {
      System.out.println("Oppgave 6: l) Metoden "
        + "er for ineffektiv. må forbedres!");
      antallFeil++;
    }

    return antallFeil;
  }

  ///// Oppgave 7 //////////////////////////////////////

  public static int oppgave7()
  {
    int antallFeil = 0;
    String s = null;

    try
    {
      s = Oblig1.flett("","");  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 7a: a) Skal ikke kaste unntak for to tomme tegnstrenger!!");
        antallFeil++;
    }

    if (s.compareTo("") != 0)
    {
      System.out.println
        ("Oppgave 7a: b) Svaret skal bli lik en tom streng!");
        antallFeil++;
    }

    try
    {
      s = Oblig1.flett("","AB");  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 7a: c) Skal ikke kaste unntak for en tom tegnstreng!!");
        antallFeil++;
    }

    if (s.compareTo("AB") != 0)
    {
      System.out.println
        ("Oppgave 7a: d) Svaret skal bli lik AB");
        antallFeil++;
    }

    try
    {
      s = Oblig1.flett("AB","");  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 7a: e) Skal ikke kaste unntak for en tom tegnstreng!!");
        antallFeil++;
    }

    if (s.compareTo("AB") != 0)
    {
      System.out.println
        ("Oppgave 7a: f) Svaret skal bli lik AB");
        antallFeil++;
    }

    s = Oblig1.flett("A", "BCDEF");

    if (s.compareTo("ABCDEF") != 0)
    {
      System.out.println
        ("Oppgave 7a: g) Svaret skal bli lik ABCDEF");
        antallFeil++;
    }

    s = Oblig1.flett("ABCDE", "F");

    if (s.compareTo("AFBCDE") != 0)
    {
      System.out.println
        ("Oppgave 7a: h) Svaret skal bli lik AFBCDE");
        antallFeil++;
    }

    s = Oblig1.flett("ACEGIK", "BDFHJLMN");

    if (s.compareTo("ABCDEFGHIJKLMN") != 0)
    {
      System.out.println
        ("Oppgave 7a: i) Svaret skal bli lik ABCDEFGHIJKLMN");
        antallFeil++;
    }

    String[] a = {};

    try
    {
      s = Oblig1.flett(a);  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 7b: a) Skal ikke kaste unntak for en tom tabell!");
        antallFeil++;
    }

    if (s.compareTo("") != 0)
    {
      System.out.println
        ("Oppgave 7b: b) Svaret skal bli lik en tom streng!");
        antallFeil++;
    }

    try
    {
      s = Oblig1.flett("","ABC","");  // kaller metoden
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.out.println
        ("Oppgave 7b: c) Skal ikke kaste unntak for en tom streng!");
        antallFeil++;
    }

    if (s.compareTo("ABC") != 0)
    {
      System.out.println
        ("Oppgave 7b: d) Svaret skal bli lik ABC");
        antallFeil++;
    }

    s = Oblig1.flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");

    if (s.compareTo("ALGORITMER OG DATASTRUKTURER") != 0)
    {
      System.out.println
        ("Oppgave 7b: e) Svaret skal bli ALGORITMER OG DATASTRUKTURER!");
        antallFeil++;
    }

    s = Oblig1.flett("AFK","BGLP","CHMQT","DINRUW","EJOSVXY");

    if (s.compareTo("ABCDEFGHIJKLMNOPQRSTUVWXY") != 0)
    {
      System.out.println
        ("Oppgave 7b: f) Svaret skal bli ABCDEFGHIJKLMNOPQRSTUVWXY!");
        antallFeil++;
    }

    return antallFeil;
  }

 ///// Hjelpemetoder /////////////////////////////

  public static void bytt(int[] a, int i, int j)
  {
    int temp = a[i]; a[i] = a[j]; a[j] = temp;
  }

  public static boolean nestePermutasjon(int[] a)
  {
    int n = a.length;
    int i = n - 2;

    while (i >= 0 && a[i] > a[i+1]) i--;

    if (i < 0) return false;

    int verdi = a[i];
    int j = n - 1;

    while (verdi > a[j]) j--;
    bytt(a, i, j);

    i++; j = n - 1;
    while (i < j) bytt(a, i++, j--);
    return true;
  }

  public static int[] randPerm(int n)  // en effektiv versjon
  {
    Random r = new Random();         // en randomgenerator
    int[] a = new int[n];            // en tabell med plass til n tall
    for (int i = 0; i < n; i++)
      a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

    for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
    {
      int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k

      int temp = a[k];
      a[k] = a[i];
      a[i] = temp;
    }

    return a;                        // permutasjonen returneres
  }
}