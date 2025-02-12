// Classe principal que testa ThreadLocal e InheritableThreadLocal
public class Principal {

    // ThreadLocal para thread independente
    static final ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        // Criando e definindo um valor no t1 para a thread principal
        final ThreadLocal<String> t1 = new ThreadLocal<String>();
        t1.set("ThreadLocal-VAL");
        System.out.println("Principal-1:" + t1.get());

        // Criando uma nova thread que acessa t1
        new Thread() {
            @Override
            public void run() {
                // Exibe null pois t1 não é compartilhado entre threads
                System.out.println("Filha-1:" + t1.get());
            }
        }.start();

        // Criando uma nova thread e passando o t1
        Sub sub = new Sub(t1);
        sub.start(); // null

        // Testando InheritableThreadLocal
        final ThreadLocal<String> itl = new InheritableThreadLocal<String>();
        itl.set("InheritableThreadLocal-VAL");
        System.out.println("Principal-2:" + itl.get());

        // Criando thread que acessa o InheritableThreadLocal
        new Thread() {
            @Override
            public void run() {
                // Exibe o valor compartilhado com a thread filha
                System.out.println("Filha-2:" + itl.get()); // InheritableThreadLocal-VAL
            }
        }.start();

        // Criando nova thread passando o InheritableThreadLocal
        Sub sub2 = new Sub(itl);
        sub2.start();
    }
}

// Subclasse que herda de Thread e acessa o valor do ThreadLocal
class Sub extends Thread {
    ThreadLocal<String> t1;

    // Construtor para receber um ThreadLocal
    public Sub(ThreadLocal<String> t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        // Exibe o valor do ThreadLocal na thread filha
        System.out.println("Sub Thread :" + t1.get());
    }
}
