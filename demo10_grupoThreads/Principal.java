import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) {
        // Grupo de Threads
        ThreadGroup grupoDeThreads = new ThreadGroup("Pesquisador");
        Resultado resultado = new Resultado();

        // Tarefa de Pesquisa
        SearchTask tarefaDePesquisa = new SearchTask(resultado);
        for (int i = 0; i < 5; i++) {
            //
            Thread thread = new Thread(grupoDeThreads, tarefaDePesquisa);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Número de Threads: %d\n", grupoDeThreads.activeCount());
        System.out.printf("Informações sobre o Grupo de Threads\n");
        // list()
        grupoDeThreads.list();

        //
        Thread[] threads = new Thread[grupoDeThreads.activeCount()];
        grupoDeThreads.enumerate(threads); //
        for (int i = 0; i < grupoDeThreads.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        //
        esperarFinalizacao(grupoDeThreads);

        //
        grupoDeThreads.interrupt();
    }

    private static void esperarFinalizacao(ThreadGroup grupoDeThreads) {
        //
        while (grupoDeThreads.activeCount() > 4) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
