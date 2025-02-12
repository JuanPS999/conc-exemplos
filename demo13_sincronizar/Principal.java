// Classe Principal que orquestra a execução das threads de Banco e Companhia
public class Principal {
    public static void main(String[] args) {
        Conta conta = new Conta(); // Cria uma nova conta
        conta.setSaldo(1000); // Define o saldo inicial

        // Criação da thread Companhia que irá adicionar valor à conta
        Companhia companhia = new Companhia(conta);
        Thread companhiaThread = new Thread(companhia);

        // Criação da thread Banco que irá subtrair valor da conta
        Banco banco = new Banco(conta);
        Thread bancoThread = new Thread(banco);

        // Exibe o saldo inicial da conta
        System.out.printf("Conta : Saldo Inicial: %f\n", conta.getSaldo());

        // Inicia as threads
        companhiaThread.start();
        bancoThread.start();

        try {
            // Espera as threads terminarem
            companhiaThread.join();
            bancoThread.join();
            // Exibe o saldo final da conta
            System.out.printf("Conta : Saldo Final: %f\n", conta.getSaldo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
