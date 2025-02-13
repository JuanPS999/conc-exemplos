import java.util.concurrent.Phaser;

// Principal - Inicializa a pesquisa de arquivos e cria as threads de pesquisa
public class Principal {
    public static void main(String[] args) {
        /*
         * Parâmetros:
         * LINHAS: número total de linhas (ou registros) na matriz de dados, aqui interpretado como
         * o número total de diretórios a serem pesquisados (não utilizado diretamente)
         */
        final int PARTICIPANTES = 3; // Número de diretórios a serem pesquisados

        // Cria um objeto Phaser com o número de participantes
        Phaser fase = new Phaser(PARTICIPANTES);

        // Cria instâncias de PesquisaArquivos para diferentes diretórios
        PesquisaArquivos sistema = new PesquisaArquivos("C:\\Windows", "log", fase);
        PesquisaArquivos aplicativos = new PesquisaArquivos("C:\\Program Files", "log", fase);
        PesquisaArquivos documentos = new PesquisaArquivos("C:\\Documents And Settings", "log", fase);

        // Cria e inicia as threads para cada pesquisa
        Thread threadSistema = new Thread(sistema, "Sistema");
        threadSistema.start();

        Thread threadAplicativos = new Thread(aplicativos, "Aplicativos");
        threadAplicativos.start();

        Thread threadDocumentos = new Thread(documentos, "Documentos");
        threadDocumentos.start();

        // Aguarda a finalização das threads (opcional)
        try {
            threadSistema.join();
            threadAplicativos.join();
            threadDocumentos.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Encerrado: %s\n", fase.isTerminated());
    }
}
