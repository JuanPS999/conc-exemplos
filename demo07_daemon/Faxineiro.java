import java.util.Date;
import java.util.Deque;

/**
 * Classe que remove eventos antigos da fila. Funciona como uma thread daemon.
 */
public class Faxineiro extends Thread {
    private Deque<Evento> deque;

    public Faxineiro(Deque<Evento> deque) {
        this.deque = deque;
        setDaemon(true); // Define a thread como daemon, encerrando-a junto com o programa principal
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date(); // Obtém a data atual
            clean(date); // Remove eventos antigos
        }
    }

    /**
     * Método que remove eventos com mais de 10 segundos.
     */
    private void clean(Date date) {
        long diferenca;
        boolean delete = false;

        if (deque.isEmpty()) { // Se a fila estiver vazia, retorna
            return;
        }

        do {
            Evento e = deque.getLast(); // Obtém o evento mais antigo da fila
            diferenca = date.getTime() - e.getData().getTime(); // Calcula a diferença de tempo

            if (diferenca > 10000) { // Se o evento tem mais de 10 segundos, remove
                System.out.printf("%s Faxineiro: Removendo %s\n", new Date(), e.getEvento());
                deque.removeLast();
                delete = true;
            }
        } while (diferenca > 10000 && !deque.isEmpty());

        if (delete) {
            System.out.printf("Faxineiro: Tamanho da fila: %d\n", deque.size());
        }
    }
}
