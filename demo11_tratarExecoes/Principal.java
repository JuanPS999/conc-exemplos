// Classe Principal: Orquestra a execução das threads com manejo de exceções
public class Principal {
    public static void main(String[] args) {
        // Criação do grupo de threads personalizado com manejo de exceções
        grupoThreads grupoDeThreads = new grupoThreads("grupoThreads");
        // Criação da tarefa a ser executada pelas threads
        Tarefa tarefa = new Tarefa();

        // Criação e inicialização de múltiplas threads
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(grupoDeThreads, tarefa);
            t.start();
        }
    }
}
