import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// GeradorRelatorio - Gera um relatório simulando um processamento com atraso
public class GeradorRelatorio implements Callable<String> {
    private String remetente; // Nome do remetente
    private String titulo; // Título do relatório

    // Construtor que inicializa o gerador com remetente e título
    public GeradorRelatorio(String remetente, String titulo) {
        this.remetente = remetente;
        this.titulo = titulo;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("%s_%s: GeradorRelatorio: Gerando um relatório durante %d segundos\n", this.remetente,
                    this.titulo, duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return remetente + ": " + titulo;
    }
}
