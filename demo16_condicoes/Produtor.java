public class Produtor implements Runnable {
    private ArmazenamentoEventos armazenamento;

    public Produtor(ArmazenamentoEventos armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            armazenamento.adicionar();
        }
    }

}
