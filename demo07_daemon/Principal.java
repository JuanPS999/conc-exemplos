import java.util.ArrayDeque;
import java.util.Deque;

public class Principal {
    public static void main(String[] args) {
        Deque<Evento> deque = new ArrayDeque<Evento>();

        Escritor escritor = new Escritor(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(escritor);
            thread.start();
        }

        Faxineiro faxineiro = new Faxineiro(deque);
        faxineiro.start();
    }
}
