import java.util.Date;

/**
 * Classe principal alternativa que utiliza join() com tempo limite.
 */
public class Principal2 {
    public static void main(String[] args) {
        // Inicia a thread para carregar fontes de dados primeiro
        FontesDeDados dsLoader = new FontesDeDados();
        Thread thread1 = new Thread(dsLoader, "FontesDeDados");
        thread1.start();

        // Inicia a thread para carregar conexões de rede
        CarregadorConexoes ncLoader = new CarregadorConexoes();
        Thread thread2 = new Thread(ncLoader, "CarregadorConexoes");
        thread2.start();

        try {
            // Aguarda no máximo 1 segundo pela finalização da primeira thread
            thread1.join(1000);

            // Aguarda indefinidamente até que a segunda thread finalize
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe mensagem final quando as threads forem concluídas
        System.out.printf("Principal: Configuração carregada: %s\n", new Date());
    }
}
