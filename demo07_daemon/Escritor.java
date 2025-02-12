import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Classe responsável por gerar eventos e adicioná-los a uma fila (Deque).
 */
public class Escritor implements Runnable {
    private Deque<Evento> deque;

    public Escritor(Deque<Evento> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { // Gera 100 eventos
            Evento evento = new Evento();
            evento.setData(new Date()); // Define a data do evento
            evento.setEvento(String.format("A Thread %s gerou o evento  => %s",
                    Thread.currentThread().threadId(), evento.getData()));

            // Adiciona o evento no início da fila
            deque.addFirst(evento);

            try {
                // Aguarda 1 segundo antes de gerar um novo evento
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
