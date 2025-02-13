// Principal - Inicializa o sistema produtor/consumidor e inicia as threads correspondentes
public class Principal {
    public static void main(String[] args) {
        // Cria um FileMock com 101 linhas, cada uma de 10 caracteres
        FileMock mock = new FileMock(101, 10);
        // Cria um Buffer com capacidade para 20 linhas
        Buffer buffer = new Buffer(20);

        // Cria uma thread produtora para inserir linhas do FileMock no Buffer
        Produtor produtor = new Produtor(mock, buffer);
        Thread threadProdutor = new Thread(produtor, "Produtor");

        // Cria 3 threads consumidoras para remover e processar linhas do Buffer
        Consumidor consumidores[] = new Consumidor[3];
        Thread threadConsumidores[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumidores[i] = new Consumidor(buffer);
            threadConsumidores[i] = new Thread(consumidores[i], "Consumidor " + i);
        }

        // Inicia a thread produtora
        threadProdutor.start();
        // Inicia as threads consumidoras
        for (int i = 0; i < 3; i++) {
            threadConsumidores[i].start();
        }
    }
}
