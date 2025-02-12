// Bilheteria2 - Classe que representa a bilheteira da Sala 2
public class Bilheteria2 implements Runnable {
    private Cinema cinema; // Referência para o objeto Cinema

    // Construtor que recebe uma instância de Cinema
    public Bilheteria2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        // Realiza as operações de venda e devolução de ingressos para a Sala 1 e Sala 2
        cinema.venderIngressos2(2);
        cinema.venderIngressos2(4);
        cinema.venderIngressos1(2);
        cinema.venderIngressos1(1);
        cinema.devolverIngressos2(2);
        cinema.venderIngressos1(3);
        cinema.venderIngressos2(2);
        cinema.venderIngressos1(2);
    }
}
