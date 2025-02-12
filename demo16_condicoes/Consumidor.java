public class Consumidor implements Runnable {
    private ArmazenamentoEventos armazenamento;

    public Consumidor(ArmazenamentoEventos armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            armazenamento.remover();
        }
    }

}
