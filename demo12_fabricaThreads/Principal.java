public class Principal {
    public static void main(String[] args) {
        FabricaThreads fabrica = new FabricaThreads("FabricaThreads");

        Tarefa tarefa = new Tarefa();
        Thread thread;
        System.out.printf("Iniciando as Threads\n");

        for (int i = 0; i < 5; i++) {
            thread = fabrica.newThread(tarefa);
            thread.start();
        }

        // Exibindo estatísticas da fábrica de threads
        System.out.printf("Estatísticas da fábrica:\n");
        System.out.printf("%s\n", fabrica.getEstatisticas());
    }
}
