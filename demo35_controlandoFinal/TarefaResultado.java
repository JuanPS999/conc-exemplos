import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// TarefaResultado - Extende FutureTask para personalizar a finalização da tarefa
public class TarefaResultado extends FutureTask<String> {
    private String nome; // Nome da tarefa

    // Construtor que recebe um Callable e extrai o nome da TarefaExecutavel
    public TarefaResultado(Callable<String> callable) {
        super(callable);
        this.nome = ((TarefaExecutavel) callable).getNome();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Foi cancelada\n", nome);
        } else {
            System.out.printf("%s: Foi finalizada\n", nome);
        }
    }
}
