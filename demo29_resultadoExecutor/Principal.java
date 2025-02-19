import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

// Principal - Inicializa o pool de threads, submete tarefas de cálculo fatorial e exibe os resultados
public class Principal {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> listaResultados = new ArrayList<>();

        Random random = new Random();
        // Submete 10 tarefas com números aleatórios para cálculo do fatorial
        for (int i = 0; i < 10; i++) {
            Integer numero = random.nextInt(10); // Número aleatório entre 0 e 9
            CalculadoraFatorial calculadora = new CalculadoraFatorial(numero);
            Future<Integer> resultado = executor.submit(calculadora);
            listaResultados.add(resultado);
        }

        // Loop que monitora o progresso das tarefas
        do {
            System.out.printf("Principal: Número de Tarefas Concluídas: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < listaResultados.size(); i++) {
                Future<Integer> resultado = listaResultados.get(i);
                System.out.printf("Principal: Tarefa %d: %s\n", i, resultado.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < listaResultados.size());

        // Exibe os resultados finais de cada tarefa
        System.out.printf("Principal: Resultados\n");
        for (int i = 0; i < listaResultados.size(); i++) {
            Future<Integer> resultado = listaResultados.get(i);
            Integer valor = null;
            try {
                valor = resultado.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Principal: Tarefa %d: %d\n", i, valor);
        }

        executor.shutdown();
    }
}
