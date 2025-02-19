import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// TarefaExecutavel - Representa uma tarefa que simula um processamento com atraso e retorna uma mensagem
public class TarefaExecutavel implements Callable<String> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome
    public TarefaExecutavel(String nome) {
        this.nome = nome;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("%s: Aguardando %d segundos para obter resultados.\n", this.nome, duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            // Se a tarefa for interrompida, simplesmente prossegue
        }
        return "Olá, mundo. Eu sou " + nome;
    }

    // Retorna o nome da tarefa
    public String getNome() {
        return this.nome;
    }
}
