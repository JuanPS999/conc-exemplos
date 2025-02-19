import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

// Tarefa - Representa uma tarefa agendada que, quando executada, imprime o horário de início e retorna uma mensagem.
public class Tarefa implements Callable<String> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formata a data para exibição
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome
    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Iniciando em: %s\n", nome, sdf.format(new Date()));
        return "Hello, world";
    }
}
