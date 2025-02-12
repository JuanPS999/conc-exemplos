// Principal - Classe que inicializa a fila de impressão e inicia as threads de impressão
public class Principal {
    public static void main(String[] args) {
        FilaDeImpressao filaDeImpressao = new FilaDeImpressao(); // Cria a instância da fila de impressão

        // Cria um array de 10 threads para simular múltiplos usuários imprimindo
        // documentos
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Tarefa(filaDeImpressao), "Thread " + i);
        }
        // Inicia todas as threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
