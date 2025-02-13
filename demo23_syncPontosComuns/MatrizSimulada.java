import java.util.Random;

// MatrizSimulada - Gera uma matriz de números aleatórios e conta ocorrências de um número específico
public class MatrizSimulada {
    private int dados[][];

    // Construtor cria a matriz com valores aleatórios e conta quantas vezes 'numero' aparece
    public MatrizSimulada(int linhas, int colunas, int numero) {
        int contador = 0;
        dados = new int[linhas][colunas];

        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = random.nextInt(10);
                if (dados[i][j] == numero) {
                    contador++;
                }
            }
        }

        System.out.printf("MatrizSimulada: Existem %d ocorrências do número %d nos dados gerados.\n", contador, numero);
    }

    // Retorna uma linha da matriz
    public int[] getLinha(int linha) {
        if (linha >= 0 && linha < dados.length) {
            return dados[linha];
        }
        return null;
    }
}
