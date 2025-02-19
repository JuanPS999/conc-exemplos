import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Principal - Agenda a execução periódica de uma tarefa e monitora o atraso entre as execuções
public class Principal {
    public static void main(String[] args) {
        // Cria um ScheduledExecutorService com 1 thread
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("Principal: Iniciando em: %s\n", new Date());

        Tarefa tarefa = new Tarefa("Tarefa");
        // Agenda a execução periódica da tarefa com atraso inicial de 1 segundo e
        // período de 2 segundos
        ScheduledFuture<?> resultado = executor.scheduleAtFixedRate(tarefa, 1, 2, TimeUnit.SECONDS);

        // Monitora o atraso atual da próxima execução a cada 500 milissegundos (por 10
        // iterações)
        for (int i = 0; i < 10; i++) {
            System.out.printf("Principal: Atraso: %d milissegundos\n", resultado.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Encerra o executor e exibe o horário de término das tarefas
        executor.shutdown();
        System.out.printf("Principal: Sem mais tarefas em: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Principal: Finalizado em: %s\n", new Date());
    }
}
