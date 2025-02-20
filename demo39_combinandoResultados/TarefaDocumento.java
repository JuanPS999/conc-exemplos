import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

// TarefaDocumento - Processa recursivamente um documento para contar ocorrências de uma palavra
public class TarefaDocumento extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private String[][] documento;
    private int inicio, fim;
    private String palavra;

    // Construtor que inicializa a tarefa com o documento, intervalo de linhas e a
    // palavra alvo
    public TarefaDocumento(String[][] documento, int inicio, int fim, String palavra) {
        this.documento = documento;
        this.inicio = inicio;
        this.fim = fim;
        this.palavra = palavra;
    }

    @Override
    protected Integer compute() {
        Integer resultado = null;
        if (fim - inicio < 10) {
            resultado = processarLinhas(documento, inicio, fim, palavra);
        } else {
            int meio = (inicio + fim) / 2;
            TarefaDocumento tarefa1 = new TarefaDocumento(documento, inicio, meio, palavra);
            TarefaDocumento tarefa2 = new TarefaDocumento(documento, meio, fim, palavra);
            invokeAll(tarefa1, tarefa2);
            try {
                resultado = agruparResultados(tarefa1.get(), tarefa2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // Processa um grupo de linhas e soma as ocorrências da palavra
    private Integer processarLinhas(String[][] documento, int inicio, int fim, String palavra) {
        List<TarefaLinha> tarefas = new ArrayList<>();
        for (int i = inicio; i < fim; i++) {
            TarefaLinha tarefa = new TarefaLinha(documento[i], 0, documento[i].length, palavra);
            tarefas.add(tarefa);
        }
        invokeAll(tarefas);
        int resultado = 0;
        for (TarefaLinha tarefa : tarefas) {
            try {
                resultado += tarefa.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // Agrupa os resultados de duas tarefas
    private Integer agruparResultados(Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }
}
