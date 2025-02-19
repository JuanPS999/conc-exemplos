import java.util.concurrent.Callable;

// Tarefa - Representa uma tarefa que executa um loop infinito, imprimindo uma mensagem periodicamente.
public class Tarefa implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Tarefa: Teste\n");
            Thread.sleep(100);
        }
    }
}
