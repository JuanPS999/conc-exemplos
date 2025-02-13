import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// FilaImpressao - Gerencia a impressão de trabalhos utilizando um Semaphore para controle de acesso ao recurso
public class FilaImpressao {
    private final Semaphore semaforo; // Semaphore que controla o número de impressões simultâneas
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formata a data para exibição

    // Construtor: Inicializa o Semaphore com 2 permissões (permite até dois trabalhos simultâneos)
    public FilaImpressao() {
        // Para uma única permissão, descomente a linha abaixo e comente a linha seguinte
        // semaforo = new Semaphore(1);
        semaforo = new Semaphore(2);
    }

    // Método que simula a impressão de um trabalho
    public void imprimirTrabalho(Object documento) {
        String nome = Thread.currentThread().getName(); // Obtém o nome da thread atual
        try {
            // Adquire uma permissão do semáforo para iniciar a impressão
            semaforo.acquire();

            // Exibe o horário de início da impressão
            System.out.println(nome + " :: em : " + sdf.format(new Date()));

            // Gera uma duração aleatória para simular o tempo de impressão (em segundos)
            long duracao = (long) (Math.random() * 10);
            System.out.printf("%s: FilaImpressao: Imprimindo um trabalho durante %d segundos\n", nome, duracao);

            // Simula o tempo de impressão
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Exibe o horário de término da impressão e libera o semáforo
            System.out.println(nome + " :: em : " + sdf.format(new Date()) + "\r\n");
            semaforo.release();
        }
    }
}
