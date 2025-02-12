import java.util.Date;

/**
 * Classe principal que gerencia o carregamento de conexões e fontes de dados,
 * garantindo que ambas as threads terminem antes de continuar a execução.
 */
public class Principal {
    public static void main(String[] args) {
        // Criação e inicialização da thread para carregar conexões
        CarregadorConexoes dsLoader = new CarregadorConexoes();
        Thread thread1 = new Thread(dsLoader, "CarregadorConexoes");
        thread1.start();

        // Criação e inicialização da thread para carregar fontes de dados
        FontesDeDados ncLoader = new FontesDeDados();
        Thread thread2 = new Thread(ncLoader, "CarregadorDados");
        thread2.start();

        try {
            // Aguarda a conclusão da primeira thread antes de continuar
            thread1.join();
            System.out.println("==========================================");

            // Aguarda a conclusão da segunda thread antes de continuar
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Após todas as threads finalizarem, exibe a mensagem final
        System.out.printf("Principal: Configuração carregada: %s\n", new Date());
    }
}
