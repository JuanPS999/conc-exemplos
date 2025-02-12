// Classe Banco que implementa Runnable para subtrair valores da conta
public class Banco implements Runnable {
    private Conta conta; // Referência para a conta a ser modificada

    // Construtor que recebe a conta
    public Banco(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            conta.subtrairValor(1000); // Subtrai 1000 da conta a cada iteração
        }
    }
}
