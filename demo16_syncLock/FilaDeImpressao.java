import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// FilaDeImpressao - Classe que simula uma fila de impressão com controle de acesso usando Lock
public class FilaDeImpressao {
    private final Lock bloqueioFila = new ReentrantLock(); // Lock para controlar o acesso à fila
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss"); // Formata a data para exibição

    // Método para imprimir um documento, simulando um tempo aleatório de impressão
    public void imprimirDocumento(Object documento) {
        bloqueioFila.lock(); // Adquire o lock para garantir exclusão mútua
        System.out.println("::  em : " + sdf.format(new Date()));
        try {
            // Simula a duração da impressão com um tempo aleatório
            long duracao = (long) (Math.random() * 10000);
            System.out.printf("%s: FilaDeImpressao: Imprimindo um documento durante %d segundos, dormindo em %s \n",
                    Thread.currentThread().getName(), (duracao / 1000), sdf.format(new Date()));
            Thread.sleep(duracao); // Simula a impressão com uma pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Exibe a hora de liberação e libera o lock
            System.out.println("::  em : " + sdf.format(new Date()) + "\r\n");
            bloqueioFila.unlock();
        }
    }
}
