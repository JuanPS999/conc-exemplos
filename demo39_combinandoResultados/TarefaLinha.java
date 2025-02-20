import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

// TarefaLinha - Processa uma linha do documento para contar as ocorrências de uma palavra
public class TarefaLinha extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private String[] linha;
    private int inicio, fim;
    private String palavra;

    // Construtor que inicializa a tarefa com a linha, intervalo de palavras e a
    // palavra alvo
    public TarefaLinha(String[] linha, int inicio, int fim, String palavra) {
        this.linha = linha;
        this.inicio = inicio;
        this.fim = fim;
        this.palavra = palavra;
    }

    @Override
    protected Integer compute() {
        Integer resultado = null;
        if (fim - inicio < 10) {
            resultado = contar(linha, inicio, fim, palavra);
        } else {
            int meio = (inicio + fim) / 2;
            TarefaLinha tarefa1 = new TarefaLinha(linha, inicio, meio, palavra);
            TarefaLinha tarefa2 = new TarefaLinha(linha, meio, fim, palavra);
            invokeAll(tarefa1, tarefa2);
            try {
                resultado = agruparResultados(tarefa1.get(), tarefa2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // Conta as ocorrências da palavra no segmento da linha
    private Integer contar(String[] linha, int inicio, int fim, String palavra) {
        int contador = 0;
        for (int i = inicio; i < fim; i++) {
            if (linha[i].equals(palavra)) {
                contador++;
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contador;
    }

    // Agrupa os resultados de duas tarefas de contagem
    private Integer agruparResultados(Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }
}
