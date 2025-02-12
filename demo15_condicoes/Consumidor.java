// Consumidor - Implementa Runnable para remover eventos do armazenamento
public class Consumidor implements Runnable {
    private ArmazenamentoEventos armazenamento; // Referência para o objeto ArmazenamentoEventos

    // Construtor que recebe uma instância de ArmazenamentoEventos
    public Consumidor(ArmazenamentoEventos armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public void run() {
        // Remove 100 eventos do armazenamento
        for (int i = 0; i < 100; i++) {
            armazenamento.remover();
        }
    }
}
