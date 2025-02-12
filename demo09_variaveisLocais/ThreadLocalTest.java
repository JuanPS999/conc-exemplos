// Classe que utiliza ThreadLocal para armazenar valores exclusivos por thread
public class ThreadLocalTest {

    // Definição de dois ThreadLocal, um para cada tipo de thread
    private static ThreadLocal<String> tl_1 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Nome da thread 1 : " + Thread.currentThread().getName();
        }
    };

    private static ThreadLocal<String> tl_2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Nome da thread 2 : " + Thread.currentThread().getName();
        }
    };

    public static void main(String[] args) {
        // Laço para criar 10 threads
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Chama o método prt() para cada thread
                    new ThreadLocalTest().prt();
                }
            }).start();
        }
    }

    // Método que imprime os valores dos ThreadLocal
    public void prt() {
        System.out.println(tl_1.get());
        System.out.println(tl_2.get());
    }
}
