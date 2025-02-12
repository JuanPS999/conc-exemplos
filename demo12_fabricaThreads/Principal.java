// Classe Principal: Orquestra a criação e execução das threads utilizando a fábrica
public class Principal {
    public static void main(String[] args) {
        // Criação da fábrica de threads com nome "FabricaThreads"
        FabricaThreads fabrica = new FabricaThreads("FabricaThreads");

        // Criação da tarefa que será executada pelas threads
        Tarefa tarefa = new Tarefa();
        Thread thread;

        // Exibe mensagem informando que as threads serão iniciadas
        System.out.printf("Iniciando as Threads\n");

        // Criação e inicialização de 5 threads
        for (int i = 0; i < 5; i++) {
            thread = fabrica.newThread(tarefa); // Cria uma nova thread
            thread.start(); // Inicia a thread
        }

        // Exibe as estatísticas da fábrica de threads
        System.out.printf("Estatísticas da fábrica:\n");
        System.out.printf("%s\n", fabrica.getEstatisticas());
    }
}
