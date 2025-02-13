import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

// PesquisaArquivos - Procura arquivos que terminem com uma extensão específica em um diretório
public class PesquisaArquivos implements Runnable {

    private String caminhoInicial;     // Caminho inicial para iniciar a busca
    private String extensao;           // Extensão dos arquivos que serão buscados
    private List<String> resultados;   // Lista para armazenar os caminhos dos arquivos encontrados
    private Phaser fase;               // Objeto Phaser para sincronizar as fases das tarefas

    // Construtor que inicializa os parâmetros da busca e o Phaser
    public PesquisaArquivos(String caminhoInicial, String extensao, Phaser fase) {
        this.caminhoInicial = caminhoInicial;
        this.extensao = extensao;
        this.fase = fase;
        resultados = new ArrayList<>();
    }

    @Override
    public void run() {
        // Aguarda o início da fase
        fase.arriveAndAwaitAdvance();

        System.out.printf("%s: Iniciando a pesquisa.\n", Thread.currentThread().getName());
        File file = new File(caminhoInicial);
        if (file.isDirectory()) {
            processarDiretorio(file);
        }

        // Verifica se há resultados; se não houver, encerra a execução
        if (!verificarResultados()) {
            return;
        }
        // Filtra os resultados com base na data de modificação
        filtrarResultados();

        if (!verificarResultados()) {
            return;
        }
        // Exibe as informações dos arquivos encontrados
        mostrarInformacoes();
        // Registra a chegada ao final e desregistra do Phaser
        fase.arriveAndDeregister();
        System.out.printf("%s: Trabalho concluído.\n", Thread.currentThread().getName());
    }

    // Método recursivo para processar diretórios
    private void processarDiretorio(File file) {
        File[] lista = file.listFiles();
        if (lista != null) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].isDirectory()) {
                    processarDiretorio(lista[i]);
                } else {
                    processarArquivo(lista[i]);
                }
            }
        }
    }

    // Processa um arquivo e adiciona ao resultado se a extensão bater
    private void processarArquivo(File file) {
        if (file.getName().endsWith(extensao)) {
            resultados.add(file.getAbsolutePath());
        }
    }

    // Filtra os resultados para manter apenas os arquivos modificados nas últimas 24 horas
    private void filtrarResultados() {
        List<String> novosResultados = new ArrayList<>();
        long dataAtual = new Date().getTime();
        for (int i = 0; i < resultados.size(); i++) {
            File file = new File(resultados.get(i));
            long dataArquivo = file.lastModified();
            if (dataAtual - dataArquivo < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                novosResultados.add(resultados.get(i));
            }
        }
        resultados = novosResultados;
    }

    // Exibe os resultados encontrados e aguarda a sincronização dos demais participantes
    private void mostrarInformacoes() {
        for (int i = 0; i < resultados.size(); i++) {
            File file = new File(resultados.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        fase.arriveAndAwaitAdvance();
    }

    // Verifica se há resultados; se vazio, informa e encerra a execução da thread
    private boolean verificarResultados() {
        if (resultados.isEmpty()) {
            System.out.printf("%s: Fase %d: 0 resultados.\n", Thread.currentThread().getName(), fase.getPhase());
            System.out.printf("%s: Fase %d: Encerrando.\n", Thread.currentThread().getName(), fase.getPhase());
            fase.arriveAndDeregister();
            return false;
        } else {
            System.out.printf("%s: Fase %d: %d resultados.\n", Thread.currentThread().getName(), fase.getPhase(), resultados.size());
            fase.arriveAndAwaitAdvance();
            return true;
        }
    }
}
