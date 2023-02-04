public class SemaphoreMain {
    public static void main(String args[]) throws  InterruptedException {
        final  CountingSemaphore cs = new CountingSemaphore(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i =0; i<5; i++) {
                        cs.aquire();
                        System.out.println("ping "+ i);
                    }
                }catch(InterruptedException ex) {

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i =0; i<5; i++) {
                        cs.release();
                        System.out.println("ping "+ i);
                    }
                }catch(InterruptedException ex) {

                }
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();

    }
}
