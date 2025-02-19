import java.util.concurrent.CompletionService;

// PedidoRelatorio - Representa uma solicitação de relatório que envia uma tarefa de geração de relatório para o CompletionService
public class PedidoRelatorio implements Runnable {
    private String nome; // Nome associado ao pedido
    private CompletionService<String> servico; // Serviço de conclusão para submeter tarefas

    // Construtor que inicializa o pedido com o nome e o serviço
    public PedidoRelatorio(String nome, CompletionService<String> servico) {
        this.nome = nome;
        this.servico = servico;
    }

    @Override
    public void run() {
        // Cria um GeradorRelatorio e o submete ao serviço de conclusão
        GeradorRelatorio gerador = new GeradorRelatorio(nome, "Relatório");
        servico.submit(gerador);
    }
}
