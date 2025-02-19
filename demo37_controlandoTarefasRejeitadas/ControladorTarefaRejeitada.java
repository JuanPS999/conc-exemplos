import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

// ControladorTarefaRejeitada - Customiza o tratamento de tarefas rejeitadas pelo executor
public class ControladorTarefaRejeitada implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.err.printf("ControladorTarefaRejeitada: A tarefa %s foi rejeitada\n", r.toString());
        System.err.printf("ControladorTarefaRejeitada: %s\n", executor.toString());
        System.err.printf("ControladorTarefaRejeitada: Terminando: %s\n", executor.isTerminating());
        System.err.printf("ControladorTarefaRejeitada: Terminado: %s\n", executor.isTerminated());
    }
}
