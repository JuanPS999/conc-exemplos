import java.util.Random; // Importação para gerar números aleatórios

// Classe Tarefa implementa Runnable para execução paralela em múltiplas threads
public class Tarefa implements Runnable {
    @Override
    public void run() {
        int resultado;
        // Instancia o gerador de números aleatórios usando o ID da thread atual
        Random aleatorio = new Random(Thread.currentThread().threadId());
        while (true) {
            // Cálculo aleatório que pode gerar exceção de divisão por zero
            try {
                resultado = 1000 / ((int) (aleatorio.nextDouble() * 1000));
                // Exibe o resultado do cálculo e o ID da thread
                System.out.printf("%s : %d\n", Thread.currentThread().threadId(), resultado);
            } catch (ArithmeticException e) {
                // Captura exceção de divisão por zero e exibe mensagem de erro
                System.out.printf("%s : Exceção de divisão por zero\n", Thread.currentThread().threadId());
                break;
            }

            // Verifica se a thread foi interrompida
            if (Thread.currentThread().isInterrupted()) {
                // Exibe mensagem de interrupção e encerra a execução
                System.out.printf("%s : Interrompida\n", Thread.currentThread().threadId());
                return;
            }
        }
    }
}
