// Resultados - Armazena a contagem de ocorrências encontradas por cada thread
public class Resultados {
    private int dados[];

    // Construtor inicializa o vetor de resultados
    public Resultados(int tamanho) {
        dados = new int[tamanho];
    }

    // Define o resultado de uma linha específica
    public void setDado(int posicao, int valor) {
        dados[posicao] = valor;
    }

    // Retorna os dados armazenados
    public int[] getDados() {
        return dados;
    }
}
