// Principal - Classe que cria e inicia as threads para simular o acesso à fila de impressão
public class Principal {
    public static void main(String[] args) {
        // Cria uma instância de PrintQueue
        PrintQueue printQueue = new PrintQueue();

        // Cria um array de 10 threads, cada uma executando uma instância de Trabalho
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Trabalho(printQueue), "Thread " + i);
        }

        // Inicia todas as threads com um pequeno atraso entre cada início
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100); // Atraso de 100ms para escalonar o início das threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
