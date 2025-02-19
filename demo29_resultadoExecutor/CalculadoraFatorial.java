import java.util.concurrent.Callable;

// CalculadoraFatorial - Calcula o fatorial de um número fornecido, simulando um pequeno atraso durante o processamento
public class CalculadoraFatorial implements Callable<Integer> {
    private Integer numero; // Número para o qual o fatorial será calculado

    // Construtor que inicializa o número
    public CalculadoraFatorial(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Integer call() throws Exception {
        int num, resultado;
        num = numero.intValue();
        resultado = 1;

        if (num == 0 || num == 1) {
            resultado = 1;
        } else {
            for (int i = 2; i <= numero; i++) {
                resultado *= i;
                // Simula um atraso de 20 milissegundos
                Thread.sleep(20);
            }
        }

        // Exibe o resultado calculado pela thread atual
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), resultado);
        return resultado;
    }
}
