// Principal - Classe que inicia a execução das threads Produtor e Consumidor
public class Principal {
    public static void main(String[] args) {
        // Cria a instância de ArmazenamentoEventos
        ArmazenamentoEventos armazenamento = new ArmazenamentoEventos();

        // Cria as threads Produtor e Consumidor
        Produtor produtor = new Produtor(armazenamento);
        Thread thread1 = new Thread(produtor);

        Consumidor consumidor = new Consumidor(armazenamento);
        Thread thread2 = new Thread(consumidor);

        // Inicia as threads (primeiro o Consumidor, depois o Produtor)
        thread2.start();
        thread1.start();
    }
}
