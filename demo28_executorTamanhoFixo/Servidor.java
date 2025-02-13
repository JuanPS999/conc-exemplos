import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Servidor - Gerencia a execução de tarefas utilizando um pool de threads com tamanho fixo
public class Servidor {
    private ThreadPoolExecutor executor; // Executor de tarefas

    // Construtor que inicializa o pool de threads fixo com 5 threads
    public Servidor() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    // Envia uma tarefa para execução e exibe estatísticas do pool de threads
    public void executarTarefa(Tarefa tarefa) {
        System.out.printf("Servidor: Uma nova tarefa chegou\n");
        executor.execute(tarefa);
        System.out.printf("Servidor: Tamanho do Pool: %d\n", executor.getPoolSize());
        System.out.printf("Servidor: Número de Threads Ativas: %d\n", executor.getActiveCount());
        System.out.printf("Servidor: Total de Tarefas: %d\n", executor.getTaskCount());
        System.out.printf("Servidor: Tarefas Concluídas: %d\n", executor.getCompletedTaskCount());
    }

    // Encerra o servidor desligando o executor
    public void encerrarServidor() {
        executor.shutdown();
    }
}
