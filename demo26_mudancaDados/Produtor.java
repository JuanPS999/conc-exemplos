import java.util.List;
import java.util.concurrent.Exchanger;

// Produtor - Preenche o buffer com mensagens e realiza a troca de dados com o consumidor
public class Produtor implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> trocador;

    // Construtor que inicializa o Produtor com o buffer e o trocador de dados
    public Produtor(List<String> buffer, Exchanger<List<String>> trocador) {
        this.buffer = buffer;
        this.trocador = trocador;
    }

    @Override
    public void run() {
        int ciclo = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Produtor: Ciclo %d\n", ciclo);

            // Preenche o buffer com 10 mensagens
            for (int j = 0; j < 10; j++) {
                String mensagem = "Evento " + ((i * 10) + j);
                System.out.printf("Produtor: %s\n", mensagem);
                buffer.add(mensagem);
            }

            // Realiza a troca de dados com o consumidor
            try {
                buffer = trocador.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Produtor: Buffer com %d elementos\n", buffer.size());
            ciclo++;
        }
    }
}
