package hjelpeklasser;

@FunctionalInterface
public interface Oppgave<T>                       // en ny utvidelse av Oppgave
{
  void utf�rOppgave(T t);                         // en abstrakt metode

  public static <T> Oppgave<T> konsollutskrift()  // en konstruksjonsmetode
  {
    return t -> System.out.print(t + " ");        // et lambda-uttrykk
  }

  default Oppgave<T> deretter(Oppgave<? super T> oppgave)
  {
    return t -> { utf�rOppgave(t); oppgave.utf�rOppgave(t); };
  }
} // Oppgave