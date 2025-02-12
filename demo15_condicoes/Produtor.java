// Produtor - Implementa Runnable para adicionar eventos ao armazenamento
public class Produtor implements Runnable {
    private ArmazenamentoEventos armazenamento; // Referência para o objeto ArmazenamentoEventos

    // Construtor que recebe uma instância de ArmazenamentoEventos
    public Produtor(ArmazenamentoEventos armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public void run() {
        // Adiciona 100 eventos ao armazenamento
        for (int i = 0; i < 100; i++) {
            armazenamento.adicionar();
        }
    }
}
