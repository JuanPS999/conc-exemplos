import java.lang.Thread.UncaughtExceptionHandler;

public class Excecoes implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Uma execao foi capturada\n");
        System.out.printf("Thread: %s\n", t.threadId());
        System.out.printf("Excecao: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Estado da Thread: %s\n", t.getState());
    }
}
