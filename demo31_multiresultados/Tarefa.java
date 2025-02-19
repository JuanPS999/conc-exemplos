import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// Tarefa - Calcula um resultado, simulando um atraso e somando valores aleatórios
public class Tarefa implements Callable<Resultado> {
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome
    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public Resultado call() throws Exception {
        System.out.printf("%s: Iniciando\n", this.nome);

        try {
            // Simula um atraso aleatório para a execução da tarefa
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("%s: Aguardando %d segundos para obter resultados.\n", this.nome, duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int valor = 0;
        // Soma 5 números aleatórios para simular um processamento
        for (int i = 0; i < 5; i++) {
            valor += (int) (Math.random() * 100);
        }

        Resultado resultado = new Resultado();
        resultado.setNome(this.nome);
        resultado.setValor(valor);
        System.out.printf("%s: Finalizando\n", this.nome);

        return resultado;
    }
}
