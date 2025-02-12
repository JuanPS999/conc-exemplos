public class Principal {
    public static void main(String[] args) {
        // Criação do grupo de threads personalizado
        grupoThreads grupoDeThreads = new grupoThreads("grupoThreads");
        Tarefa tarefa = new Tarefa();

        // Criação e inicialização de múltiplas threads
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(grupoDeThreads, tarefa);
            t.start();
        }
    }
}
