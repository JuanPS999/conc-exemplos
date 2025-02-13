import java.util.concurrent.TimeUnit;

// Participante - Representa um participante que, após um atraso aleatório, registra sua chegada na videoconferência
public class Participante implements Runnable {
    private Videoconferencia videoconferencia; // Referência para a videoconferência
    private String nome;                      // Nome do participante

    // Construtor que inicializa o participante com a videoconferência e seu nome
    public Participante(Videoconferencia videoconferencia, String nome) {
        this.videoconferencia = videoconferencia;
        this.nome = nome;
    }

    @Override
    public void run() {
        // Simula um atraso aleatório antes do participante chegar
        Long duracao = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Registra a chegada do participante na videoconferência
        videoconferencia.chegar(nome);
    }
}
