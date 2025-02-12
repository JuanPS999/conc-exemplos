import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Simula o carregamento de conexões de rede.
 */
public class CarregadorConexoes implements Runnable {

    @Override
    public void run() {
        System.out.printf("Carregador de conexões carregando: %s\n", new Date());
        try {
            // Simula um tempo de carregamento de 4 segundos
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Carregamento de conexões terminou: %s\n", new Date());
    }
}
