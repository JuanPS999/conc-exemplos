import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Classe InfoPrecos: Gerencia os preços e utiliza ReadWriteLock para sincronizar operações de leitura e escrita
public class InfoPrecos {
    private double preco1;  // Valor do Preço 1
    private double preco2;  // Valor do Preço 2
    private ReadWriteLock lock;  // Bloqueio para controle de acesso

    // Construtor que inicializa os preços e o bloqueio
    public InfoPrecos() {
        preco1 = 1.0;
        preco2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    // Método para obter o Preço 1 com bloqueio de leitura
    public double getPreco1() {
        lock.readLock().lock();
        System.out.println("Preço 1 ======>");
        try {
            Thread.sleep(100);  // Simula atraso na leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double valor = preco1;
        System.out.println("Preço 2 <======");
        lock.readLock().unlock();
        return valor;
    }

    // Método para obter o Preço 2 com bloqueio de leitura
    public double getPreco2() {
        lock.readLock().lock();
        System.out.println("Preço 1 lido ======>");
        try {
            Thread.sleep(100);  // Simula atraso na leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double valor = preco2;
        System.out.println("Preço 2 lido <======");
        lock.readLock().unlock();
        return valor;
    }

    // Método para modificar ambos os preços com bloqueio de escrita
    public void setPrices(double preco1, double preco2) {
        lock.writeLock().lock();
        System.out.println(" at " + new Date());
        try {
            Thread.sleep(2 * 1000);  // Simula um tempo maior para a operação de escrita
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.preco1 = preco1;
        this.preco2 = preco2;
        System.out.println("         at " + new Date());
        lock.writeLock().unlock();
    }
}
