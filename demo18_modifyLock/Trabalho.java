import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trabalho implements Runnable {
  private PrintQueue printQueue;

  public Trabalho(PrintQueue printQueue) {
    this.printQueue = printQueue;
  }

  @Override
  public void run() {
    System.out.printf("%s: Escrevendo tabalho.\n", Thread.currentThread().getName());
    printQueue.printJob(new Object());
    System.out.printf("%s: O documento foi escrito.\n", Thread.currentThread().getName());
  }
}
