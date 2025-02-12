import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class Escritor implements Runnable {
    //
    Deque<Evento> deque;

    public Escritor(Deque<Evento> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Evento Evento = new Evento();
            Evento.setData(new Date());
            Evento.setEvento(String.format("A Thread %s gerou o evento  => %s", Thread.currentThread().threadId(),
                    String.valueOf(Evento.getData())));
            deque.addFirst(Evento);
            try {
                //
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
