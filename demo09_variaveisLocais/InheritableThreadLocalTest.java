// Classe que utiliza InheritableThreadLocal para compartilhar valores entre threads filhas

// Criando um InheritableThreadLocal com valor inicial "olá"
private static InheritableThreadLocal<StringBuffer> ITL = new InheritableThreadLocal<StringBuffer>() {
    @Override
    protected StringBuffer initialValue() {
        return new StringBuffer("olá");
    }
};

public static void main(String[] args) {
    // Imprime o valor do InheritableThreadLocal para a thread principal
    System.out.println(Thread.currentThread().getName() + " : " + ITL.get());

    // Criando e iniciando uma nova thread
    new Thread(new Runnable() {
        @Override
        public void run() {
            // Imprime o valor do InheritableThreadLocal para a thread interna
            System.out.println(Thread.currentThread().getName() + " : " + ITL.get());

            // Criando uma nova thread interna para alterar o valor do
            // InheritableThreadLocal
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Imprime o valor antes da alteração
                    System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
                    // Modifica o valor do StringBuffer
                    ((StringBuffer) ITL.get()).append(", wqf");
                    // Imprime o valor após a alteração
                    System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
                }
            }, "interno-interno").start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Imprime o valor após a execução da thread interna
            System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
        }
    }, "interno").start();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }

    // Imprime o valor na thread principal após a execução das outras threads
    System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
}
