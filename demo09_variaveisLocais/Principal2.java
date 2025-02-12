public class Principal2 {
    private static InheritableThreadLocal<StringBuffer> holder = new InheritableThreadLocal<StringBuffer>() {
        @Override
        protected StringBuffer initialValue() {
            return new StringBuffer("aaa");
        };
    };

    public static void main(String[] args) {
        System.out.println("início=" + holder.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1-início=" + holder.get());

                holder.set(new StringBuffer("vvvvvvvvvvvvv"));
                holder.set(holder.get().append(", olá"));

                System.out.println("thread1-fim=" + holder.get());
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //
        System.out.println("fim=" + holder.get());
    }
}
