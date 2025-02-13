// Trabalho - Representa uma tarefa de impressão que solicita a impressão de um documento
public class Trabalho implements Runnable {
    private FilaImpressao filaImpressao; // Referência para a fila de impressão

    // Construtor que inicializa o Trabalho com uma instância de FilaImpressao
    public Trabalho(FilaImpressao filaImpressao) {
        this.filaImpressao = filaImpressao;
    }

    @Override
    public void run() {
        // Solicita a impressão de um documento através da FilaImpressao
        filaImpressao.imprimirTrabalho(new Object());
    }
}
