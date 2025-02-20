import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

// ProcessadorPasta - Processa recursivamente os diretórios e retorna uma lista de arquivos com uma extensão específica
public class ProcessadorPasta extends RecursiveTask<List<String>> {

    private static final long serialVersionUID = 1L;

    private String caminhoInicial; // Caminho inicial para a busca
    private String extensao; // Extensão dos arquivos a serem procurados

    // Construtor que inicializa o ProcessadorPasta com o caminho e a extensão
    // desejada
    public ProcessadorPasta(String caminhoInicial, String extensao) {
        this.caminhoInicial = caminhoInicial;
        this.extensao = extensao;
    }

    @Override
    protected List<String> compute() {
        List<String> lista = new ArrayList<>();
        List<ProcessadorPasta> tarefas = new ArrayList<>();

        File arquivo = new File(caminhoInicial);
        File[] conteudo = arquivo.listFiles();
        if (conteudo != null) {
            for (int i = 0; i < conteudo.length; i++) {
                if (conteudo[i].isDirectory()) {
                    ProcessadorPasta tarefa = new ProcessadorPasta(conteudo[i].getAbsolutePath(), extensao);
                    tarefa.fork(); // Subdivide a tarefa para processar o subdiretório
                    tarefas.add(tarefa);
                } else {
                    if (verificarArquivo(conteudo[i].getName())) {
                        lista.add(conteudo[i].getAbsolutePath());
                    }
                }
            }
            if (tarefas.size() > 50) {
                System.out.printf("%s: %d tarefas foram geradas.\n", arquivo.getAbsolutePath(), tarefas.size());
            }
            adicionarResultados(lista, tarefas);
        }
        return lista;
    }

    // Método que agrega os resultados das tarefas subdivididas à lista principal
    private void adicionarResultados(List<String> lista, List<ProcessadorPasta> tarefas) {
        for (ProcessadorPasta tarefa : tarefas) {
            lista.addAll(tarefa.join());
        }
    }

    // Verifica se o arquivo possui a extensão desejada
    private boolean verificarArquivo(String nome) {
        return nome.endsWith(extensao);
    }
}
