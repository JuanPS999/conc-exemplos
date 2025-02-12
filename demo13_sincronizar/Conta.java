// Classe Conta que possui saldo e métodos sincronizados para manipulação do saldo
public class Conta {
    private double saldo; // Saldo da conta

    // Getter do saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter do saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método sincronizado para adicionar valor ao saldo
    public synchronized void adicionarValor(double valor) {
        double temp = saldo;
        try {
            Thread.sleep(10); // Simula o tempo de processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp += valor;
        saldo = temp;
    }

    // Método sincronizado para subtrair valor do saldo
    public synchronized void subtrairValor(double valor) {
        double temp = saldo;
        try {
            Thread.sleep(10); // Simula o tempo de processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp -= valor;
        saldo = temp;
    }
}
