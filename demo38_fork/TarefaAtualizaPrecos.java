import java.util.List;
import java.util.concurrent.RecursiveAction;

// TarefaAtualizaPrecos - Atualiza os preços de uma lista de produtos utilizando o paradigma Fork/Join
public class TarefaAtualizaPrecos extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private List<Produto> produtos; // Lista de produtos a serem atualizados
    private int primeiro; // Índice inicial do segmento
    private int ultimo; // Índice final do segmento
    private double incremento; // Percentual de incremento a ser aplicado

    // Construtor que inicializa os atributos da tarefa
    public TarefaAtualizaPrecos(List<Produto> produtos, int primeiro, int ultimo, double incremento) {
        this.produtos = produtos;
        this.primeiro = primeiro;
        this.ultimo = ultimo;
        this.incremento = incremento;
    }

    @Override
    protected void compute() {
        if (ultimo - primeiro < 10) {
            atualizarPrecos();
        } else {
            int meio = (ultimo + primeiro) / 2;
            System.out.printf("TarefaAtualizaPrecos: Tarefas pendentes: %d\n", getQueuedTaskCount());
            TarefaAtualizaPrecos t1 = new TarefaAtualizaPrecos(produtos, primeiro, meio + 1, incremento);
            TarefaAtualizaPrecos t2 = new TarefaAtualizaPrecos(produtos, meio + 1, ultimo, incremento);
            System.out.println("t1: " + t1);
            System.out.println("t2: " + t2);
            System.out.println();
            invokeAll(t1, t2);
        }
    }

    // Atualiza os preços dos produtos no segmento definido
    private void atualizarPrecos() {
        System.out.println("primeiro: " + this.primeiro + "  ultimo: " + ultimo);
        System.out.println();
        for (int i = primeiro; i < ultimo; i++) {
            Produto produto = produtos.get(i);
            produto.setPreco(produto.getPreco() * (1 + incremento));
        }
    }

    @Override
    public String toString() {
        return "TarefaAtualizaPrecos [primeiro=" + primeiro + ", ultimo=" + ultimo + "]";
    }
}
