import java.util.concurrent.CyclicBarrier;

// Classe principal - Configura e inicia as threads
public class Principal {
    public static void main(String[] args) {
        final int LINHAS = 10000;
        final int COLUNAS = 1000;
        final int NUMERO_BUSCA = 5;
        final int LINHAS_POR_THREAD = 2000;

        // Criação da matriz simulada
        MatrizSimulada matriz = new MatrizSimulada(LINHAS, COLUNAS, NUMERO_BUSCA);

        // Armazena os resultados das buscas
        Resultados resultados = new Resultados(LINHAS);

        // Cria o agrupador que somará os resultados ao final
        Agrupador agrupador = new Agrupador(resultados);

        final int PARTICIPANTES = 5; // Número de threads pesquisadoras
        CyclicBarrier barreira = new CyclicBarrier(PARTICIPANTES, agrupador);

        // Cria e inicia as threads de pesquisa
        Pesquisador pesquisadores[] = new Pesquisador[PARTICIPANTES];
        for (int i = 0; i < PARTICIPANTES; i++) {
            pesquisadores[i] = new Pesquisador(i * LINHAS_POR_THREAD, (i * LINHAS_POR_THREAD) + LINHAS_POR_THREAD, matriz,
                    resultados, NUMERO_BUSCA, barreira);
            Thread thread = new Thread(pesquisadores[i]);
            thread.start();
        }

        System.out.printf("Principal: A thread principal terminou sua execução.\n");
    }
}
