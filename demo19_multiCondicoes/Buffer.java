import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Buffer - Gerencia um buffer de linhas com múltiplas condições para sincronização
public class Buffer {
    private LinkedList<String> buffer; // Armazena as linhas
    private int maxSize;               // Tamanho máximo do buffer
    private ReentrantLock lock;        // Lock para sincronização
    private Condition lines;           // Condição para sinalizar a existência de linhas
    private Condition space;           // Condição para sinalizar a existência de espaço
    private boolean pendingLines;      // Indica se ainda há linhas pendentes de inserção

    // Construtor: Inicializa o buffer com um tamanho máximo e configura as condições
    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    // Método para inserir uma linha no buffer
    public void insert(String line) {
        lock.lock();
        try {
            // Aguarda enquanto o buffer estiver cheio
            while (buffer.size() == maxSize) {
                space.await();
            }
            // Insere a linha e informa o tamanho atual do buffer
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            // Sinaliza que há linhas disponíveis para leitura
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // Método para remover uma linha do buffer
    public String get() {
        String line = null;
        lock.lock();
        try {
            // Aguarda enquanto o buffer estiver vazio e ainda houver linhas pendentes
            while ((buffer.size() == 0) && hasPendingLines()) {
                lines.await();
            }
            // Se ainda houver linhas pendentes, remove a primeira linha do buffer
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                // Sinaliza que há espaço disponível no buffer
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    // Define se ainda há linhas pendentes de inserção
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    // Verifica se ainda há linhas pendentes ou se o buffer não está vazio
    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }
}
