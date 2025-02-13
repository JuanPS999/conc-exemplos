import java.util.concurrent.CountDownLatch;

// Videoconferencia - Gerencia a videoconferência e aguarda a chegada dos participantes utilizando CountDownLatch
public class Videoconferencia implements Runnable {
    private final CountDownLatch controlador; // Controla a contagem dos participantes aguardados

    // Construtor: Inicializa o CountDownLatch com o número de participantes esperados
    public Videoconferencia(int numeroParticipantes) {
        controlador = new CountDownLatch(numeroParticipantes);
    }

    // Método para registrar a chegada de um participante
    public void chegar(String nome) {
        System.out.printf("%s chegou.\n", nome);
        // Decrementa o contador do CountDownLatch
        controlador.countDown();
        System.out.printf("Videoconferencia: Aguardando por %d participantes.\n", controlador.getCount());
    }

    @Override
    public void run() {
        System.out.printf("Videoconferencia: Inicialização: %d participantes aguardando.\n\n", controlador.getCount());
        try {
            // Aguarda até que o contador chegue a zero (todos os participantes chegaram)
            controlador.await();
            System.out.printf("\r\nVideoconferencia: Todos os participantes chegaram.\n");
            System.out.printf("Videoconferencia: Vamos iniciar...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
