// Principal - Classe que inicializa e executa os threads das bilheteiras
public class Principal {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(); // Cria uma instância de Cinema

        // Cria os objetos Bilheteria1 e Bilheteria2 com a referência ao objeto cinema
        Bilheteria1 bilheteria1 = new Bilheteria1(cinema);
        Thread thread1 = new Thread(bilheteria1, "Bilheteria1");

        Bilheteria2 bilheteria2 = new Bilheteria2(cinema);
        Thread thread2 = new Thread(bilheteria2, "Bilheteria2");

        thread1.start(); // Inicia a execução da Bilheteria1
        thread2.start(); // Inicia a execução da Bilheteria2

        try {
            thread1.join(); // Aguarda a conclusão da thread1
            thread2.join(); // Aguarda a conclusão da thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o número de vagas restantes em ambas as salas
        System.out.printf("Vagas na Sala 1: %d\n", cinema.getVagasSala1());
        System.out.printf("Vagas na Sala 2: %d\n", cinema.getVagasSala2());
    }
}
