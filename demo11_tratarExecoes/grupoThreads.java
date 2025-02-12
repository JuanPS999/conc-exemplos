// Definição da classe grupoThreads: Customização de um grupo de threads com manejo de exceções
public class grupoThreads extends ThreadGroup {
    // Construtor que recebe o nome do grupo de threads
    public grupoThreads(String nome) {
        super(nome);
    }

    @Override
    // Método sobrecarregado para tratar exceções não capturadas nas threads
    public void uncaughtException(Thread t, Throwable e) {
        // Exibe uma mensagem indicando que a thread gerou uma exceção
        System.out.printf("A thread %s lançou uma exceção\n", t.threadId());
        // Imprime a stack trace da exceção
        e.printStackTrace(System.out);
        // Exibe uma mensagem informando que o restante das threads será interrompido
        System.out.printf("Terminando o restante das threads\n");
        // Interrompe todas as threads no grupo
        interrupt();
    }
}
