import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Servidor - Gerencia a execução de tarefas utilizando um pool de threads
public class Servidor {
    private ThreadPoolExecutor executor; // Executor de tarefas

    // Construtor: Inicializa o executor com um pool de threads "cached"
    public Servidor() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    // Executa uma tarefa e exibe estatísticas do pool de threads
    public void executarTarefa(Tarefa tarefa) {
        System.out.printf("Servidor: Uma nova tarefa chegou\n");
        executor.execute(tarefa);
        System.out.printf("Servidor: Tamanho do Pool: %d\n", executor.getPoolSize());
        System.out.printf("Servidor: Contagem de Threads Ativas: %d\n", executor.getActiveCount());
        System.out.printf("Servidor: Tarefas Completadas: %d\n", executor.getCompletedTaskCount());
    }

    // Encerra o servidor desligando o executor
    public void encerrarServidor() {
        executor.shutdown();
    }
}
