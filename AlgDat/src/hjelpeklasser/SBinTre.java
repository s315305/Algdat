package hjelpeklasser;

import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class SBinTre<T> // implements Beholder<T>
{
  private static final class Node<T> // en indre nodeklasse
  {
    private T verdi;                 // nodens verdi
    private Node<T> venstre, h�yre;  // venstre og h�yre barn

    private Node(T verdi, Node<T> v, Node<T> h)  // konstrukt�r
    {
      this.verdi = verdi;
      venstre = v;
      h�yre = h;
    }

    private Node(T verdi)  // konstrukt�r
    {
      this(verdi, null, null);
    }
  } // class Node

  private Node<T> rot;                       // peker til rotnoden
  private int antall;                        // antall noder
  private final Comparator<? super T> comp;  // komparator

  public SBinTre(Comparator<? super T> c)    // konstrukt�r
  {
    rot = null;
    antall = 0;
    comp = c;
  }
  
  public static <T extends Comparable<? super T>> SBinTre<T> sbintre()
  {
    return new SBinTre<>(Comparator.naturalOrder());
  }

  public static <T> SBinTre<T> sbintre(Comparator<? super T> c)
  {
    return new SBinTre<>(c);
  }

  public int antall()        // antall verdier i treet
  {
    return antall;
  }

  public boolean tom()       // er treet tomt?
  {
    return antall == 0;
  }
  
  public final boolean leggInn(T verdi)    // skal ligge i class SBinTre
  {
    Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

    Node<T> p = rot, q = null;               // p starter i roten
    int cmp = 0;                             // hjelpevariabel

    while (p != null)       // fortsetter til p er ute av treet
    {
      q = p;                                 // q er forelder til p
      cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
      p = cmp < 0 ? p.venstre : p.h�yre;     // flytter p
    }

    // p er n� null, dvs. ute av treet, q er den siste vi passerte

    p = new Node<>(verdi);                   // oppretter en ny node

    if (q == null) rot = p;                  // p blir rotnode
    else if (cmp < 0) q.venstre = p;         // venstre barn til q
    else q.h�yre = p;                        // h�yre barn til q

    antall++;                                // �n verdi mer i treet
    return true;                             // vellykket innlegging
  }
  
  private static int h�yde(Node<?> p)  // ? betyr vilk�rlig type
  {
    if (p == null) return -1;          // et tomt tre har h�yde -1

    return 1 + Math.max(h�yde(p.venstre), h�yde(p.h�yre));
  }

  public int h�yde()
  {
    return h�yde(rot);                 // kaller hjelpemetoden
  }
  
  public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c)
  {
    SBinTre<T> tre = new SBinTre<>(c);             // komparatoren c
    s.forEach(tre::leggInn);                       // bygger opp treet
    return tre;                                    // treet returneres
  }

  public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s)
  {
    return sbintre(s, Comparator.naturalOrder());  // naturlig ordning
  }
  
  private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
  {
    if (p.venstre != null) inorden(p.venstre,oppgave);
    oppgave.utf�rOppgave(p.verdi);
    if (p.h�yre != null) inorden(p.h�yre,oppgave);
  }

  public void inorden(Oppgave <? super T> oppgave)
  {
    if (!tom()) inorden(rot,oppgave);
  }
  
  public String toString()
  {
    StringJoiner s = new StringJoiner(", ", "[", "]");
    if (!tom()) inorden(x -> s.add(x != null ? x.toString() : "null"));
    return s.toString();
  }

} // class SBinTre 
