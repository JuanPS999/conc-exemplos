import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Principal - Inicializa o pool de threads, submete a tarefa e a cancela após um determinado tempo.
public class Principal {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Tarefa tarefa = new Tarefa();

        System.out.printf("Principal: Executando a Tarefa\n");

        Future<String> resultado = executor.submit(tarefa);

        try {
            // Aguarda 2 segundos antes de cancelar a tarefa
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Principal: Cancelando a Tarefa\n");
        resultado.cancel(true);

        System.out.printf("Principal: Cancelada: %s\n", resultado.isCancelled());
        System.out.printf("Principal: Concluída: %s\n", resultado.isDone());

        executor.shutdown();
        System.out.printf("Principal: O executor terminou\n");
    }
}
