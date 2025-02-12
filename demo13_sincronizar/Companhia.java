// Classe Companhia que implementa Runnable para adicionar valores à conta
public class Companhia implements Runnable {
    private Conta conta; // Referência para a conta a ser modificada

    // Construtor que recebe a conta
    public Companhia(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            conta.adicionarValor(1000); // Adiciona 1000 à conta a cada iteração
        }
    }
}
