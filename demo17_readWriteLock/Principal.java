// Classe Principal: Inicializa a aplicação criando threads para leitores e um escritor
public class Principal {
    public static void main(String[] args) {
        // Cria uma instância de InfoPrecos com preços iniciais
        InfoPrecos infoPrecos = new InfoPrecos();

        // Cria 5 leitores, cada um em sua própria thread
        Leitor leitores[] = new Leitor[5];
        Thread threadsLeitor[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            leitores[i] = new Leitor(infoPrecos);
            threadsLeitor[i] = new Thread(leitores[i]);
        }

        // Cria um escritor em uma thread separada
        Escritor escritor = new Escritor(infoPrecos);
        Thread threadEscritor = new Thread(escritor);

        // Inicia as threads dos leitores
        for (int i = 0; i < 5; i++) {
            threadsLeitor[i].start();
        }
        // Inicia a thread do escritor
        threadEscritor.start();
    }
}
