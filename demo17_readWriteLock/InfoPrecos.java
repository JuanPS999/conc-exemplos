import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InfoPrecos {
  private double preco1;
  private double preco2;

  private ReadWriteLock lock;

  public InfoPrecos() {
    preco1 = 1.0;
    preco2 = 2.0;

    lock = new ReentrantReadWriteLock();
  }

  public double getPreco1() {
    lock.readLock().lock();

    System.out.println("Preço 1 ======>");  
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    double valor = preco1;
    System.out.println("Preço 2 <======");

    lock.readLock().unlock();

    return valor;
  }

  public double getPreco2() {
    lock.readLock().lock();

    System.out.println("Preço 1 lido ======>");
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    double valor = preco2;
    System.out.println("Preço 2 lido <======");

    lock.readLock().unlock();

    return valor;
  }

  public void setPrices(double preco1, double preco2) {

    lock.writeLock().lock();
    System.out.println(" at " + new Date());
    try {
      Thread.sleep(2 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.preco1 = preco1;
    this.preco2 = preco2;

    System.out.println("         at " + new Date());
    lock.writeLock().unlock();
  }
}
