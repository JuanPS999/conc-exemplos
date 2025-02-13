// Principal - Classe que inicializa o sistema de impressão e cria as threads para executar os Trabalhos
public class Principal {
    public static void main(String[] args) {
        // Cria uma instância de FilaImpressao para gerenciar os trabalhos de impressão
        FilaImpressao filaImpressao = new FilaImpressao();

        // Cria um array de 10 threads, cada uma executando um Trabalho de impressão
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Trabalho(filaImpressao), "Thread " + i);
        }

        // Inicia todas as threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
