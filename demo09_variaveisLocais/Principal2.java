// Classe que utiliza InheritableThreadLocal para compartilhar StringBuffer entre threads
public class Principal2 {

    // InheritableThreadLocal para armazenar um StringBuffer
    private static InheritableThreadLocal<StringBuffer> holder = new InheritableThreadLocal<StringBuffer>() {
        @Override
        protected StringBuffer initialValue() {
            return new StringBuffer("aaa");
        }
    };

    public static void main(String[] args) {
        // Exibe o valor inicial do InheritableThreadLocal
        System.out.println("início=" + holder.get());

        // Criando uma nova thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Exibe o valor do InheritableThreadLocal na thread filha
                System.out.println("thread1-início=" + holder.get());

                // Modifica o valor do StringBuffer
                holder.set(new StringBuffer("vvvvvvvvvvvvv"));
                holder.set(holder.get().append(", olá"));

                // Exibe o valor após a modificação
                System.out.println("thread1-fim=" + holder.get());
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o valor do InheritableThreadLocal na thread principal
        System.out.println("fim=" + holder.get());
    }
}
