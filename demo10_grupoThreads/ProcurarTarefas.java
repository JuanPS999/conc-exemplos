import java.util.Date; // Importa a classe Date para obter o tempo atual
import java.util.Random; // Importa a classe Random para gerar números aleatórios
import java.util.concurrent.TimeUnit; // Importa TimeUnit para controle de tempo

// Classe ProcurarTarefas: Implementa Runnable para executar uma tarefa em uma thread separada
public class ProcurarTarefas implements Runnable {
    // Objeto Resultado para armazenar o nome da thread que executa a tarefa
    private Resultado resultado;

    // Construtor que recebe um objeto Resultado
    public ProcurarTarefas(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public void run() {
        // Obtém o nome da thread atual
        String nome = Thread.currentThread().getName();
        System.out.printf("Thread %s: Início\n", nome);
        try {
            // Executa a tarefa simulada
            executarTarefa();
            // Armazena o nome da thread no objeto Resultado
            resultado.setNome(nome);
        } catch (InterruptedException e) {
            // Em caso de interrupção, imprime mensagem e encerra a execução
            System.out.printf("Thread %s: Interrompida\n", nome);
            return;
        }
        System.out.printf("Thread %s: Fim\n", nome);
    }

    // Método que simula a execução de uma tarefa com tempo aleatório de espera
    private void executarTarefa() throws InterruptedException {
        Random aleatorio = new Random(new Date().getTime());
        // Gera um valor aleatório entre 0 e 100
        int valor = (int) (aleatorio.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), valor);
        // Faz a thread dormir pelo tempo aleatório em segundos
        TimeUnit.SECONDS.sleep(valor);
    }
}
