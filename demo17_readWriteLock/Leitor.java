// Classe Leitor: Responsável por ler os preços utilizando os métodos de leitura com bloqueio
public class Leitor implements Runnable {
    private InfoPrecos infoPrecos;  // Referência para o objeto que contém os preços

    // Construtor que inicializa a referência para InfoPrecos
    public Leitor(InfoPrecos infoPrecos) {
        this.infoPrecos = infoPrecos;
    }

    @Override
    public void run() {
        // Loop para realizar 10 leituras dos preços
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), infoPrecos.getPreco1());
            System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), infoPrecos.getPreco2());
        }
    }
}
