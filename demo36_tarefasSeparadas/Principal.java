import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Principal - Inicializa o ambiente, cria pedidos de relatório e processa os resultados
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> servico = new ExecutorCompletionService<>(executor);

        // Cria pedidos de relatório para "Face" e "Online"
        PedidoRelatorio pedidoFace = new PedidoRelatorio("Face", servico);
        PedidoRelatorio pedidoOnline = new PedidoRelatorio("Online", servico);
        Thread threadFace = new Thread(pedidoFace);
        Thread threadOnline = new Thread(pedidoOnline);

        // Cria um processador de relatórios para consumir os resultados
        ProcessadorRelatorio processador = new ProcessadorRelatorio(servico);
        Thread threadProcessador = new Thread(processador);

        System.out.printf("Principal: Iniciando as Threads\n");
        threadFace.start();
        threadOnline.start();
        threadProcessador.start();

        try {
            System.out.printf("Principal: Aguardando os geradores de relatório.\n");
            threadFace.join();
            threadOnline.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Principal: Encerrando o executor.\n");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processador.setFim(true);
        System.out.printf("Principal: Encerramento\n");
    }
}
