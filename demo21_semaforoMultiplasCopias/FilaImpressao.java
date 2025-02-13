import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// FilaImpressao - Gerencia a impressão de trabalhos utilizando um Semaphore para controlar o acesso a múltiplas impressoras
public class FilaImpressao {
    private final Semaphore semaforo;       // Semaphore que controla o número de impressoras simultâneas (3)
    private final boolean[] impressorasLivres; // Array que indica se cada impressora está livre
    private final Lock lockImpressoras;     // Lock para proteger o acesso ao array de impressoras
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formata a data para exibição

    // Construtor: Inicializa o Semaphore, o array de impressoras e o lock
    public FilaImpressao() {
        semaforo = new Semaphore(3);
        impressorasLivres = new boolean[3];
        for (int i = 0; i < 3; i++) {
            impressorasLivres[i] = true;
        }
        lockImpressoras = new ReentrantLock();
    }

    // Método que simula a impressão de um trabalho
    public void imprimirTrabalho(Object documento) {
        String nome = Thread.currentThread().getName();
        try {
            // Adquire uma permissão do semáforo para acessar uma impressora
            semaforo.acquire();

            System.out.println(nome + "  em: " + sdf.format(new Date()));

            // Obtém o índice de uma impressora livre
            int impressoraAtribuida = obterImpressora();

            // Gera uma duração aleatória para simular o tempo de impressão (em segundos)
            long duracao = (long) (Math.random() * 10);
            System.out.printf("%s: FilaImpressao: Imprimindo um trabalho na Impressora %d durante %d segundos\n", 
                              nome, impressoraAtribuida, duracao);
            TimeUnit.SECONDS.sleep(duracao);

            // Marca a impressora como livre após a impressão
            impressorasLivres[impressoraAtribuida] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(nome + " libera semáforo em: " + sdf.format(new Date()) + "\r\n");
            // Libera a permissão do semáforo
            semaforo.release();
        }
    }

    // Método para obter uma impressora livre, protegendo o acesso com lock
    private int obterImpressora() {
        int ret = -1;
        try {
            lockImpressoras.lock();
            for (int i = 0; i < impressorasLivres.length; i++) {
                if (impressorasLivres[i]) {
                    ret = i;
                    impressorasLivres[i] = false; // Marca a impressora como ocupada
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockImpressoras.unlock();
        }
        return ret;
    }
}
