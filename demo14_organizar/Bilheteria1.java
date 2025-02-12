// Bilheteria1 - Classe que representa a bilheteira da Sala 1
public class Bilheteria1 implements Runnable {
    private Cinema cinema; // Referência para o objeto Cinema

    // Construtor que recebe uma instância de Cinema
    public Bilheteria1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        // Realiza as operações de venda e devolução de ingressos para a Sala 1 e Sala 2
        cinema.venderIngressos1(3);
        cinema.venderIngressos1(2);
        cinema.venderIngressos2(2);
        cinema.devolverIngressos1(3);
        cinema.venderIngressos1(5);
        cinema.venderIngressos2(2);
        cinema.venderIngressos2(2);
        cinema.venderIngressos2(2);
    }
}
