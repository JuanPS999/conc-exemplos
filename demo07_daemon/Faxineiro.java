import java.util.Date;
import java.util.Deque;

public class Faxineiro extends Thread {
    private Deque<Evento> deque;

    public Faxineiro(Deque<Evento> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long diferenca;
        boolean delete;

        if (deque.size() == 0) {
            return;
        }

        delete = false;
        do {
            Evento e = deque.getLast();
            diferenca = date.getTime() - e.getData().getTime();
            if (diferenca > 10000) {
                System.out.printf("%s Faxineiro: %s\n", String.valueOf(new Date()), e.getEvento());
                deque.removeLast();
                delete = true;
            }
        } while (diferenca > 10000);

        if (delete) {
            System.out.printf("Faxineiro: Tamanho da fila: %d\n", deque.size());
        }
    }
}
