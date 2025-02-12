import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// ArmazenamentoEventos - Gerencia o armazenamento de eventos (datas) com um tamanho máximo
public class ArmazenamentoEventos {
    private int tamanhoMaximo; // Tamanho máximo do armazenamento
    private List<Date> armazenamento; // Lista para armazenar os eventos

    // Construtor: Inicializa o tamanho máximo e a lista de armazenamento
    public ArmazenamentoEventos() {
        tamanhoMaximo = 10;
        armazenamento = new LinkedList<>();
    }

    // Método sincronizado para adicionar um evento à lista
    public synchronized void adicionar() {
        // Enquanto o armazenamento estiver cheio, aguarda a liberação
        while (armazenamento.size() == tamanhoMaximo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Adiciona um novo evento (data atual) e exibe o tamanho atual do armazenamento
        armazenamento.add(new Date());
        System.out.printf("Adicionado: %d \n", armazenamento.size());
        // Notifica uma thread aguardando que um item foi adicionado
        notify();
    }

    // Método sincronizado para remover um evento da lista
    public synchronized void remover() {
        // Enquanto o armazenamento estiver vazio, aguarda a disponibilidade de um
        // evento
        while (armazenamento.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Remove o primeiro evento da lista e exibe o tamanho atual e o evento removido
        System.out.printf("Removido: %d: %s \n", armazenamento.size(), ((LinkedList<?>) armazenamento).poll());
        // Notifica uma thread aguardando que um item foi removido
        notify();
    }
}
