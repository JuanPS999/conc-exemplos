import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArmazenamentoEventos {
    private int tamanhoMaximo;

    private List<Date> armazenamento;

    public ArmazenamentoEventos() {
        tamanhoMaximo = 10;
        armazenamento = new LinkedList<>();
    }

    public synchronized void adicionar() {
        while (armazenamento.size() == tamanhoMaximo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        armazenamento.add(new Date());
        System.out.printf("Adicionado: %d \n", armazenamento.size());

        notify();
    }

    public synchronized void remover() {
        while (armazenamento.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Removido: %d: %s \n", armazenamento.size(), ((LinkedList<?>) armazenamento).poll());
        notify();
    }
}
