import java.util.concurrent.TimeUnit;

// Tarefa - Representa uma tarefa que simula a geração de um relatório com atraso
public class Tarefa implements Runnable {
    private String nome; // Nome da tarefa

    // Construtor que inicializa a tarefa com um nome
    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.printf("Tarefa %s: Iniciando\n", nome);
        try {
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("Tarefa %s: Gerando um relatório durante %d segundos\n", nome, duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Tarefa %s: Terminando\n", nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
