import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
    private Resultado resultado;

    public SearchTask(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public void run() {
        String nome = Thread.currentThread().getName();
        System.out.printf("Thread %s: Início\n", nome);
        try {
            executarTarefa();
            resultado.setName(nome);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrompida\n", nome);
            return;
        }
        System.out.printf("Thread %s: Fim\n", nome);
    }

    private void executarTarefa() throws InterruptedException {
        Random aleatorio = new Random(new Date().getTime());
        int valor = (int) (aleatorio.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), valor);
        TimeUnit.SECONDS.sleep(valor); //
    }
}
