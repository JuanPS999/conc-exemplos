import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Classe principal que executa a thread do relógio e a interrompe após 5
 * segundos.
 */
public class Principal {
    public static void main(String[] args) {
        // Criação de uma instância do relógio
        Relogio relogio = new Relogio();

        // Criação e inicialização da thread
        Thread thread = new Thread(relogio);
        thread.start();

        try {
            // Aguarda 5 segundos antes de interromper a thread do relógio
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrompe a thread do relógio antes que ela complete os 10 ciclos
        thread.interrupt();
    }
}
