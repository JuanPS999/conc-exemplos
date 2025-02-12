public class Principal {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setSaldo(1000);

        Companhia companhia = new Companhia(conta);
        Thread companhiaThread = new Thread(companhia);

        Banco banco = new Banco(conta);
        Thread bancoThread = new Thread(banco);

        System.out.printf("Conta : Saldo Inicial: %f\n", conta.getSaldo());

        companhiaThread.start();
        bancoThread.start();

        try {
            companhiaThread.join();
            bancoThread.join();
            System.out.printf("Conta : Saldo Final: %f\n", conta.getSaldo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
