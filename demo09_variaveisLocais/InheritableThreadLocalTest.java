public class InheritableThreadLocalTest {
    private static InheritableThreadLocal<StringBuffer> ITL = new InheritableThreadLocal<StringBuffer>() {
        @Override
        protected StringBuffer initialValue() {
            return new StringBuffer("olá");
        }
    };

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
                        ((StringBuffer) ITL.get()).append(", wqf");
                        System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
                    }
                }, "interno-interno").start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
            }
        }, "interno").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " : " + ITL.get());
    }
}
