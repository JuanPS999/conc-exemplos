public class grupoThreads extends ThreadGroup {
    public grupoThreads(String nome) {
        super(nome);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("A thread %s lançou uma exceção\n", t.threadId());
        e.printStackTrace(System.out);
        System.out.printf("Terminando o restante das threads\n");
        interrupt();
    }
}
