// Cinema - Classe que representa a operação de venda e devolução de ingressos para duas salas de cinema
public class Cinema {
    private long vagasCinema1; // Vagas disponíveis na Sala 1
    private long vagasCinema2; // Vagas disponíveis na Sala 2
    private final Object controleCinema1, controleCinema2; // Objetos para controle de sincronização das salas

    // Construtor que inicializa as vagas das duas salas e os objetos de controle
    public Cinema() {
        controleCinema1 = new Object();
        controleCinema2 = new Object();
        vagasCinema1 = 20;
        vagasCinema2 = 20;
    }

    // Método sincronizado para vender ingressos da Sala 1
    public boolean venderIngressos1(int quantidade) {
        synchronized (controleCinema1) { // Bloqueia o controle da Sala 1 para garantir thread safety
            if (quantidade <= vagasCinema1) {
                vagasCinema1 -= quantidade;
                return true;
            }
            return false;
        }
    }

    // Método sincronizado para vender ingressos da Sala 2
    public boolean venderIngressos2(int quantidade) {
        synchronized (controleCinema2) { // Bloqueia o controle da Sala 2 para garantir thread safety
            if (quantidade <= vagasCinema2) {
                vagasCinema2 -= quantidade;
                return true;
            }
            return false;
        }
    }

    // Método sincronizado para devolver ingressos da Sala 1
    public boolean devolverIngressos1(int quantidade) {
        synchronized (controleCinema1) { // Bloqueia o controle da Sala 1 para garantir thread safety
            vagasCinema1 += quantidade;
            return true;
        }
    }

    // Método sincronizado para devolver ingressos da Sala 2
    public boolean devolverIngressos2(int quantidade) {
        synchronized (controleCinema2) { // Bloqueia o controle da Sala 2 para garantir thread safety
            vagasCinema2 += quantidade;
            return true;
        }
    }

    // Métodos para obter o número de vagas restantes nas salas
    public long getVagasSala1() {
        return vagasCinema1;
    }

    public long getVagasSala2() {
        return vagasCinema2;
    }
}
