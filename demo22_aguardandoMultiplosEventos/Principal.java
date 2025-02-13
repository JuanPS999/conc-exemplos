// Principal - Inicializa a videoconferência e cria threads para os participantes
public class Principal {
    public static void main(String[] args) {
        // Cria uma videoconferência que espera 10 participantes
        Videoconferencia videoconferencia = new Videoconferencia(10);

        // Cria e inicia uma thread para a videoconferência
        Thread threadVideoconferencia = new Thread(videoconferencia);
        threadVideoconferencia.start();

        // Cria 10 threads para os participantes, cada um com seu nome
        for (int i = 0; i < 10; i++) {
            Participante participante = new Participante(videoconferencia, "Participante " + i);
            Thread t = new Thread(participante);
            t.start();
        }
    }
}
