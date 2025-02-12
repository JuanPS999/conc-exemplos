import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Barbearia {
  private final Semaphore cadeiras;
  private final Semaphore barbeiro;
  private final Semaphore clientePronto;
  private final AtomicInteger clientesNaEspera;

  public Barbearia(int numCadeiras) {
    this.cadeiras = new Semaphore(numCadeiras);
    this.barbeiro = new Semaphore(0);
    this.clientePronto = new Semaphore(0);
    this.clientesNaEspera = new AtomicInteger(0);
  }

  public void cortarCabelo(int id) throws InterruptedException {
    if (cadeiras.tryAcquire()) {
      clientesNaEspera.incrementAndGet();
      System.out.println("Cliente " + id + " sentou e está esperando.");
      barbeiro.release();
      clientePronto.acquire();
      cadeiras.release();
      clientesNaEspera.decrementAndGet();
      System.out.println("Cliente " + id + " está sendo atendido.");
    } else {
      System.out.println("Cliente " + id + " não encontrou vaga e foi embora.");
    }
  }
  public void atenderClientes() throws InterruptedException {
    while (true) {
      barbeiro.acquire();
      if (clientesNaEspera.get() > 0) {
        System.out.println("Barbeiro está cortando cabelo...");
        Thread.sleep(1200);
        clientePronto.release();
      } else {
        System.out.println("Barbeiro está dormindo.");
      }
    }
  }
}
