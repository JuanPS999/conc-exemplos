import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Pesquisador - Procura o número na matriz e armazena os resultados
public class Pesquisador implements Runnable {
    private int primeiraLinha;
    private int ultimaLinha;
    private MatrizSimulada matriz;
    private Resultados resultados;
    private int numero;
    private final CyclicBarrier barreira;

    // Construtor define a faixa de linhas e os objetos necessários para a busca
    public Pesquisador(int primeiraLinha, int ultimaLinha, MatrizSimulada matriz, Resultados resultados, int numero, CyclicBarrier barreira) {
        this.primeiraLinha = primeiraLinha;
        this.ultimaLinha = ultimaLinha;
        this.matriz = matriz;
        this.resultados = resultados;
        this.numero = numero;
        this.barreira = barreira;
    }

    @Override
    public void run() {
        int contador;
        System.out.printf("%s: Processando linhas de %d a %d.\n", Thread.currentThread().getName(), primeiraLinha, ultimaLinha);

        for (int i = primeiraLinha; i < ultimaLinha; i++) {
            int linha[] = matriz.getLinha(i);
            contador = 0;
            for (int j = 0; j < linha.length; j++) {
                if (linha[j] == numero) {
                    contador++;
                }
            }
            resultados.setDado(i, contador);
        }

        System.out.printf("%s: Linhas processadas.\n", Thread.currentThread().getName());

        try {
            barreira.await(); // Aguarda todas as threads finalizarem antes de continuar
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
