import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Classe que representa um relógio que imprime a hora atual a cada segundo.
 */
public class Relogio implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Executa 10 vezes
            System.out.printf("%s\n", new Date()); // Exibe a data e hora atual
            try {
                // Faz a thread "dormir" por 1 segundo antes de continuar
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // Mensagem exibida caso a thread seja interrompida
                System.out.printf("O relógio foi interrompido\n");
            }
        }
    }
}
