public class Bilheteria1 implements Runnable {
    private Cinema cinema;

    public Bilheteria1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
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
