public class Principal {

    public static void main(String[] args) {
        ArmazenamentoEventos armazenamento = new ArmazenamentoEventos();

        Produtor produtor = new Produtor(armazenamento);
        Thread thread1 = new Thread(produtor);

        Consumidor consumidor = new Consumidor(armazenamento);
        Thread thread2 = new Thread(consumidor);

        thread2.start();
        thread1.start();
    }

}
