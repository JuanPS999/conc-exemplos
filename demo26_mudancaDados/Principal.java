import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

// Principal - Inicializa o sistema de troca de dados entre Produtor e Consumidor
public class Principal {
    public static void main(String[] args) {
        // Cria dois buffers para iniciar o processo
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        // Cria o trocador de dados entre as threads
        Exchanger<List<String>> trocador = new Exchanger<>();

        // Instancia o Produtor e o Consumidor com os respectivos buffers e o trocador
        Produtor produtor = new Produtor(buffer1, trocador);
        Consumidor consumidor = new Consumidor(buffer2, trocador);

        // Cria e inicia as threads
        Thread threadProdutor = new Thread(produtor);
        Thread threadConsumidor = new Thread(consumidor);

        threadProdutor.start();
        threadConsumidor.start();
    }
}
