import java.util.Date;
import java.util.concurrent.TimeUnit;

// Tarefa - Representa uma tarefa a ser executada, simulando um processamento com duração aleatória
public class Tarefa implements Runnable {
    private Date dataInicio; // Data de criação da tarefa
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome e registra a data de criação
    public Tarefa(String nome) {
        dataInicio = new Date();
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.printf("%s: Tarefa %s: Criada em: %s\n", Thread.currentThread().getName(), nome, dataInicio);
        System.out.printf("%s: Tarefa %s: Iniciada em: %s\n", Thread.currentThread().getName(), nome, new Date());
        try {
            // Simula o processamento da tarefa com um tempo aleatório (em segundos)
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("%s: Tarefa %s: Executando por %d segundos\n", Thread.currentThread().getName(), nome,
                    duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Tarefa %s: Finalizada em: %s\n", Thread.currentThread().getName(), nome, new Date());
    }
}
