import java.util.Random;

// DocumentoSimulado - Gera um documento representado por uma matriz de strings com palavras aleatórias
public class DocumentoSimulado {
    private String palavras[] = { "the", "hello", "goodbye", "packt", "java",
            "thread", "pool", "random", "class", "main" };

    // Gera um documento com numLinhas linhas e numPalavras por linha, buscando a
    // ocorrência de uma palavra específica
    public String[][] gerarDocumento(int numLinhas, int numPalavras, String palavra) {
        int contador = 0;
        String[][] documento = new String[numLinhas][numPalavras];
        Random random = new Random();
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numPalavras; j++) {
                int indice = random.nextInt(palavras.length);
                documento[i][j] = palavras[indice];
                if (documento[i][j].equals(palavra)) {
                    contador++;
                }
            }
        }
        System.out.printf("DocumentoSimulado: A palavra aparece %d vezes no documento.\n", contador);
        return documento;
    }
}
