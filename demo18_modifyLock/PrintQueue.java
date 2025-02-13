import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// PrintQueue - Gerencia o acesso à impressora usando um ReentrantLock com opção de fairness
public class PrintQueue {
    // O lock é configurado com fairness (true) para garantir a ordem de acesso entre as threads
    private final Lock queueLock = new ReentrantLock(true);
    // private final Lock queueLock = new ReentrantLock(false); // Alternativa sem fairness

    public void printJob(Object document) {
        // Primeira seção de impressão:
        queueLock.lock(); // Adquire o lock
        try {
            // Gera uma duração aleatória para simular a impressão
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in first code block\n", 
                Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration); // Simula a impressão com pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock(); // Libera o lock
        }

        // Segunda seção de impressão:
        queueLock.lock(); // Adquire novamente o lock para outra operação
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in second code block\n", 
                Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration); // Simula a impressão com pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock(); // Libera o lock
        }
    }
}
