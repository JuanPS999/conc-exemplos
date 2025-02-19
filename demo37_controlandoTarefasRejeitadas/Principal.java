import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Principal - Inicializa o pool de threads, submete tarefas e demonstra o cancelamento de novas tarefas após o shutdown
public class Principal {
    public static void main(String[] args) {
        ControladorTarefaRejeitada controlador = new ControladorTarefaRejeitada();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        // Configura o executor para usar o controlador personalizado de tarefas
        // rejeitadas
        executor.setRejectedExecutionHandler(controlador);

        System.out.printf("Principal: Iniciando.\n");
        for (int i = 0; i < 3; i++) {
            Tarefa tarefa = new Tarefa("Tarefa" + i);
            executor.submit(tarefa);
        }

        System.out.printf("Principal: Encerrando o Executor.\n");
        executor.shutdown();
        System.out.println("Encerrado: " + executor.isShutdown());

        System.out.printf("Principal: Enviando outra Tarefa.\n");
        Tarefa tarefa = new Tarefa("TarefaRejeitada");
        executor.submit(tarefa);

        System.out.printf("Principal: Fim.\n");
    }
}
