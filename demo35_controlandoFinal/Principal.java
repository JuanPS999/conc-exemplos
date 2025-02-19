import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Principal - Inicializa o pool de threads, submete as tarefas e, após um tempo, cancela as tarefas
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<TarefaResultado> listaTarefas = new ArrayList<>();

        // Cria 5 tarefas e as submete ao executor
        for (int i = 0; i < 5; i++) {
            TarefaExecutavel tarefa = new TarefaExecutavel("Tarefa " + i);
            TarefaResultado tarefaResultado = new TarefaResultado(tarefa);
            listaTarefas.add(tarefaResultado);
            executor.submit(tarefaResultado);
        }

        // Aguarda 5 segundos para que algumas tarefas possam ser concluídas
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cancela todas as tarefas
        for (int i = 0; i < listaTarefas.size(); i++) {
            listaTarefas.get(i).cancel(true);
        }

        System.out.println("\nImprimindo os resultados:\n");
        // Tenta obter e imprimir os resultados das tarefas não canceladas
        for (int i = 0; i < listaTarefas.size(); i++) {
            try {
                if (!listaTarefas.get(i).isCancelled()) {
                    System.out.printf("Principal: %s\n", listaTarefas.get(i).get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
