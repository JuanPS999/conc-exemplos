public class Conta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public synchronized void adicionarValor(double valor) {
        double temp = saldo;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        temp += valor;
        saldo = temp;
    }

    public synchronized void subtrairValor(double valor) {
        double temp = saldo;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp -= valor;
        saldo = temp;
    }
}
