// Tarefa - Implementa Runnable para simular a impressão de um documento
public class Tarefa implements Runnable {
    private FilaDeImpressao filaDeImpressao; // Referência para a fila de impressão

    // Construtor que recebe uma instância de FilaDeImpressao
    public Tarefa(FilaDeImpressao filaDeImpressao) {
        this.filaDeImpressao = filaDeImpressao;
    }

    @Override
    public void run() {
        // Chama o método de impressão da fila de impressão
        filaDeImpressao.imprimirDocumento(new Object());
    }
}

