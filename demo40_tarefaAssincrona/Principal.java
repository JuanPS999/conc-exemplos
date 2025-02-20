import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

// Principal - Inicializa o pool Fork/Join e executa a tarefa de processamento de pastas
public class Principal {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        ProcessadorPasta sistema = new ProcessadorPasta("C:\\Windows", "log");
        ProcessadorPasta aplicativos = new ProcessadorPasta("C:\\Program Files", "log");
        ProcessadorPasta documentos = new ProcessadorPasta("C:\\Documents And Settings", "log");

        pool.execute(sistema);
        pool.execute(aplicativos);
        pool.execute(documentos);

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
        } while ((!sistema.isDone()) || (!aplicativos.isDone()) || (!documentos.isDone()));

        pool.shutdown();

        List<String> resultados;

        resultados = sistema.join();
        System.out.printf("Sistema: %d arquivos encontrados.\n", resultados.size());

        resultados = aplicativos.join();
        System.out.printf("Aplicativos: %d arquivos encontrados.\n", resultados.size());

        resultados = documentos.join();
        System.out.printf("Documentos: %d arquivos encontrados.\n", resultados.size());
    }
}
