import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Classe principal que inicia threads escritoras e o faxineiro (daemon).
 */
public class Principal {
    public static void main(String[] args) {
        // Fila de eventos compartilhada entre as threads
        Deque<Evento> deque = new ArrayDeque<>();

        // Inicia três threads escritoras que geram eventos
        Escritor escritor = new Escritor(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(escritor);
            thread.start();
        }

        // Inicia a thread daemon responsável pela limpeza dos eventos antigos
        Faxineiro faxineiro = new Faxineiro(deque);
        faxineiro.start();
    }
}
