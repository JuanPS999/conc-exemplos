// Classe Escritor: Responsável por modificar os preços na instância de InfoPrecos
public class Escritor implements Runnable {
    private InfoPrecos infoPrecos; // Referência para o objeto que contém os preços

    // Construtor que inicializa o objeto InfoPrecos
    public Escritor(InfoPrecos infoPrecos) {
        this.infoPrecos = infoPrecos;
    }

    @Override
    public void run() {
        // Loop para realizar três atualizações nos preços
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            // Modifica os preços com valores aleatórios
            infoPrecos.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                // Aguarda 2 milissegundos antes da próxima modificação
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
