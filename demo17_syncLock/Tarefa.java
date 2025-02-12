public class Tarefa implements Runnable {
    private FilaDeImpressao filaDeImpressao;

    public Tarefa(FilaDeImpressao filaDeImpressao) {
        this.filaDeImpressao = filaDeImpressao;
    }

    @Override
    public void run() {
        filaDeImpressao.imprimirDocumento(new Object());
    }
}
