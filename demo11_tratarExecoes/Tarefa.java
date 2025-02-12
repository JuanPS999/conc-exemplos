
import java.util.Random;

public class Tarefa implements Runnable {

    @Override
    public void run() {
        int resultado;
        Random aleatorio = new Random(Thread.currentThread().threadId());
        while (true) {
            // Cálculo aleatório que pode gerar exceção de divisão por zero
            resultado = 1000 / ((int) (aleatorio.nextDouble() * 1000));
            System.out.printf("%s : %d\n", Thread.currentThread().threadId(), resultado);

            // Verifica se a thread foi interrompida
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrompida\n", Thread.currentThread().threadId());
                return;
            }
        }
    }
}
