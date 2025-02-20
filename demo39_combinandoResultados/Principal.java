import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

// Principal - Inicializa o documento simulado, executa a tarefa Fork/Join para contar ocorrências e exibe os resultados
public class Principal {
    public static void main(String[] args) {
        DocumentoSimulado mock = new DocumentoSimulado();
        String[][] documento = mock.gerarDocumento(10, 100, "the");

        TarefaDocumento tarefa = new TarefaDocumento(documento, 0, 10, "the");
        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(tarefa);

        do {
            System.out.printf("******************************************\n");
            System.out.printf("Principal: Paralelismo: %d\n", pool.getParallelism());
            System.out.printf("Principal: Threads Ativas: %d\n", pool.getActiveThreadCount());
            System.out.printf("Principal: Tarefas em Fila: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Principal: Tarefas Roubadas: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!tarefa.isDone());

        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Principal: A palavra aparece %d vezes no documento.\n", tarefa.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
