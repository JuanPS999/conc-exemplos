import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Cliente extends Thread {
  private final Barbearia barbearia;
  private final int id;
  public Cliente(Barbearia barbearia, int id) {
    this.barbearia = barbearia;
    this.id = id;
  }

  public void run() {
    try {
      barbearia.cortarCabelo(id);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
