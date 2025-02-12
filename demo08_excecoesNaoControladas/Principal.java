public class Principal {
    public static void main(String[] args) {
        Tarefas tarefa = new Tarefas();
        Thread thread = new Thread(tarefa);
        thread.setUncaughtExceptionHandler(new Excecoes());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");
    }
}
