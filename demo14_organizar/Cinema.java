public class Cinema {
    private long vagasCinema1;
    private long vagasCinema2;

    private final Object controleCinema1, controleCinema2;

    public Cinema() {
        controleCinema1 = new Object();
        controleCinema2 = new Object();

        vagasCinema1 = 20;
        vagasCinema2 = 20;
    }

    public boolean venderIngressos1(int quantidade) {
        synchronized (controleCinema1) {
            if (quantidade < vagasCinema1) {
                vagasCinema1 -= quantidade;
                return true;
            }

            return false;
        }
    }

    public boolean venderIngressos2(int quantidade) {
        synchronized (controleCinema2) {
            if (quantidade < vagasCinema2) {
                vagasCinema2 -= quantidade;
                return true;
            }

            return false;
        }
    }

    public boolean devolverIngressos1(int quantidade) {
        synchronized (controleCinema1) {
            vagasCinema1 += quantidade;
            return true;
        }
    }

    public boolean devolverIngressos2(int quantidade) {
        synchronized (controleCinema2) {
            vagasCinema2 += quantidade;
            return true;
        }
    }

    public long getVagasSala1() {
        return vagasCinema1;
    }

    public long getVagasSala2() {
        return vagasCinema2;
    }
}
