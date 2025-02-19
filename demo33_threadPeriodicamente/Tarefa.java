// Tarefa - Representa uma tarefa que é executada periodicamente
public class Tarefa implements Runnable {
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome
    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.printf("%s: Executado em: %s\n", nome, new java.util.Date());
    }
}
