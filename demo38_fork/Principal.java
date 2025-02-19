import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

// Principal - Classe que inicializa a lista de produtos, cria a tarefa Fork/Join para atualização de preços e monitora o progresso
public class Principal {
    public static void main(String[] args) {
        GeradorListaProdutos gerador = new GeradorListaProdutos();
        List<Produto> produtos = gerador.gerar(40);

        // Cria a tarefa para atualizar os preços dos produtos com incremento de 20%
        TarefaAtualizaPrecos tarefa = new TarefaAtualizaPrecos(produtos, 0, produtos.size(), 0.20);

        // Cria um ForkJoinPool para executar a tarefa
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(tarefa);

        // Monitora o progresso da execução
        do {
            System.out.printf("Principal: Número de Threads Ativas: %d\n", pool.getActiveThreadCount());
            System.out.printf("Principal: Tarefas Roubadas: %d\n", pool.getStealCount());
            System.out.printf("Principal: Paralelismo: %d\n", pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!tarefa.isDone());

        pool.shutdown();

        if (tarefa.isCompletedNormally()) {
            System.out.printf("Principal: O processo foi concluído normalmente.\n");
        }

        // Verifica se algum produto não teve seu preço atualizado para 12 (10 * 1.20 =
        // 12)
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getPreco() != 12) {
                System.out.printf("Produto %s: %.2f\n", produto.getNome(), produto.getPreco());
            }
        }

        System.out.println("Principal: Fim do programa.\n");
    }
}
