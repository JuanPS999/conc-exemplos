public class Principal {
    static final ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        final ThreadLocal<String> t1 = new ThreadLocal<String>();
        t1.set("ThreadLocal-VAL");
        System.out.println("Principal-1:" + t1.get());
        new Thread() {
            @Override
            public void run() {
                System.out.println("Filha-1:" + t1.get()); // null
            }
        }.start();

        Sub sub = new Sub(t1);
        sub.start(); // null

        final ThreadLocal<String> itl = new InheritableThreadLocal<String>();
        itl.set("InheritableThreadLocal-VAL");
        System.out.println("Principal-2:" + itl.get());
        new Thread() {
            @Override
            public void run() {
                System.out.println("Filha-2:" + itl.get()); // InheritableThreadLocal-VAL
            }
        }.start();

        Sub sub2 = new Sub(itl);
        sub2.start();
    }

    /**
     * Principal-1:ThreadLocal-VAL
     * Filha-1:null
     * Principal-2:InheritableThreadLocal-VAL
     * Sub Thread :null
     * Filha-2:InheritableThreadLocal-VAL
     * Sub Thread :InheritableThreadLocal-VAL
     */
}

class Sub extends Thread {
    ThreadLocal<String> t1;

    public Sub(ThreadLocal<String> t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("Sub Thread :" + t1.get());
    }
}
