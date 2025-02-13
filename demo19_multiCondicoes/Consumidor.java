import java.util.Random;

// Consumidor - Implementa Runnable para remover e processar linhas do buffer
public class Consumidor implements Runnable {
    private Buffer buffer; // Referência para o buffer compartilhado

    // Construtor que inicializa com o buffer fornecido
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Continua removendo linhas enquanto houver linhas pendentes
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    // Simula o processamento de uma linha com um atraso aleatório
    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
