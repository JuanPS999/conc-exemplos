import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FilaDeImpressao {

    private final Lock bloqueioFila = new ReentrantLock();
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss");

    public void imprimirDocumento(Object documento) {

        bloqueioFila.lock();

        System.out.println("::  em : " + sdf.format(new Date()));

        try {
            long duracao = (long) (Math.random() * 10000);
            System.out.printf("%s: FilaDeImpressao: Imprimindo um documento durante %d segundos, dormindo em %s \n",
                    Thread.currentThread().getName(),
                    (duracao / 1000), sdf.format(new Date()));
            Thread.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            System.out.println("::  em : " + sdf.format(new Date()) + "\r\n");

            bloqueioFila.unlock();
        }
    }
}
