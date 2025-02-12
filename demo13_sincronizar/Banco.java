public class Banco implements Runnable {
    private Conta conta;

    public Banco(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            conta.subtrairValor(1000);
        }
    }

}
