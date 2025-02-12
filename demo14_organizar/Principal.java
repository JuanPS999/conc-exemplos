public class Principal {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Bilheteria1 bilheteria1 = new Bilheteria1(cinema);
        Thread thread1 = new Thread(bilheteria1, "Bilheteria1");

        Bilheteria2 bilheteria2 = new Bilheteria2(cinema);
        Thread thread2 = new Thread(bilheteria2, "Bilheteria2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Vagas na Sala 1: %d\n", cinema.getVagasSala1());
        System.out.printf("Vagas na Sala 2: %d\n", cinema.getVagasSala2());

    }
}
