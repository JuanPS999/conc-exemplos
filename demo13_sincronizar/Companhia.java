public class Companhia implements Runnable {
    private Conta conta;

    public Companhia(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            conta.adicionarValor(1000);
        }
    }

}
