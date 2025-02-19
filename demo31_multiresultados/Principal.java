import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Principal - Inicializa o pool de threads, submete tarefas e exibe os resultados
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Tarefa> listaTarefas = new ArrayList<>();

        // Cria 3 tarefas com nomes distintos
        for (int i = 0; i < 3; i++) {
            Tarefa tarefa = new Tarefa("Tarefa-" + i);
            listaTarefas.add(tarefa);
        }

        List<Future<Resultado>> listaResultados = null;
        System.out.println(new Date());
        try {
            // Submete todas as tarefas e espera que todas sejam concluídas
            listaResultados = executor.invokeAll(listaTarefas);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Finaliza o executor
        executor.shutdown();
        System.out.println(new Date());

        System.out.printf("Principal: Imprimindo os resultados\n");
        for (int i = 0; i < listaResultados.size(); i++) {
            Future<Resultado> futuro = listaResultados.get(i);
            Resultado resultado = null;
            try {
                resultado = futuro.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Principal: %s: %d\n", resultado.getNome(), resultado.getValor());
        }
    }
}
