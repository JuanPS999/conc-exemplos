public class Bilheteria2 implements Runnable {
    private Cinema cinema;

    public Bilheteria2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
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
