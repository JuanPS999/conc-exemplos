import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Principal - Classe que agenda a execução de múltiplas tarefas com atrasos incrementais
public class Principal {
    public static void main(String[] args) {
        // Cria um ScheduledExecutorService com 1 thread
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Principal: Iniciando em: %s\n", new Date());

        // Agenda 5 tarefas com atrasos crescentes (1s, 2s, 3s, 4s e 5s)
        for (int i = 0; i < 5; i++) {
            Tarefa tarefa = new Tarefa("Tarefa-" + i);
            // schedule(Callable<V> callable, long delay, TimeUnit unit)
            executor.schedule(tarefa, i + 1, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            // Aguarda até que todas as tarefas sejam concluídas ou até 1 dia
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Principal: Finalizando em: %s\n", new Date());
    }
}
