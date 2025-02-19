import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// ProcessadorRelatorio - Consome os resultados dos relatórios submetidos e os imprime
public class ProcessadorRelatorio implements Runnable {
    private CompletionService<String> servico; // Serviço de conclusão para obter resultados
    private boolean fim; // Flag para controlar o término do processamento

    // Construtor que inicializa o processador com o serviço de conclusão
    public ProcessadorRelatorio(CompletionService<String> servico) {
        this.servico = servico;
        this.fim = false;
    }

    @Override
    public void run() {
        while (!fim) {
            try {
                // Tenta obter o resultado, aguardando até 20 segundos
                Future<String> resultado = servico.poll(20, TimeUnit.SECONDS);
                if (resultado != null) {
                    String relatorio = resultado.get();
                    System.out.printf("ProcessadorRelatorio: Relatório recebido: %s\n", relatorio);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ProcessadorRelatorio: Encerrando\n");
    }

    // Método para sinalizar o fim do processamento
    public void setFim(boolean fim) {
        this.fim = fim;
    }
}
