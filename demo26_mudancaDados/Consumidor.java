import java.util.List;
import java.util.concurrent.Exchanger;

// Consumidor - Recebe o buffer trocado pelo produtor, processa e esvazia-o
public class Consumidor implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> trocador;

    // Construtor que inicializa o Consumidor com o buffer e o trocador de dados
    public Consumidor(List<String> buffer, Exchanger<List<String>> trocador) {
        this.buffer = buffer;
        this.trocador = trocador;
    }

    @Override
    public void run() {
        int ciclo = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumidor: Ciclo %d\n", ciclo);

            // Realiza a troca de dados para receber o buffer preenchido pelo produtor
            try {
                buffer = trocador.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Consumidor: Buffer com %d elementos\n", buffer.size());

            // Processa e remove 10 mensagens do buffer
            for (int j = 0; j < 10; j++) {
                String mensagem = buffer.get(0);
                System.out.printf("Consumidor: %s\n", mensagem);
                buffer.remove(0);
            }
            ciclo++;
        }
    }
}
