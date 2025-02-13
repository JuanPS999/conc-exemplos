// Agrupador - Soma os resultados das buscas e exibe o total
public class Agrupador implements Runnable {
    private Resultados resultados;

    // Construtor recebe os resultados das buscas
    public Agrupador(Resultados resultados) {
        this.resultados = resultados;
    }

    @Override
    public void run() {
        int resultadoFinal = 0;
        System.out.printf("Agrupador: Processando os resultados...\n");
        int dados[] = resultados.getDados();
        for (int numero : dados) {
            resultadoFinal += numero;
        }
        System.out.printf("Agrupador: Resultado total: %d.\n", resultadoFinal);
    }
}
