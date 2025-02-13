// Trabalho - Implementa Runnable e representa uma tarefa de impressão
public class Trabalho implements Runnable {
    private PrintQueue printQueue; // Referência para a fila de impressão

    // Construtor que inicializa o PrintQueue
    public Trabalho(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        // Mensagem indicando o início da tarefa
        System.out.printf("%s: Escrevendo tabalho.\n", Thread.currentThread().getName());
        // Executa o método que imprime o trabalho
        printQueue.printJob(new Object());
        // Mensagem indicando a finalização da tarefa
        System.out.printf("%s: O documento foi escrito.\n", Thread.currentThread().getName());
    }
}
