public class CountingSemaphore {
    int max_count;
    int used_permits = 0;
    public CountingSemaphore(int max_count ) {
        this.max_count = max_count;
    }

    public synchronized void aquire() throws InterruptedException{
        while(used_permits == max_count) {
            wait();
        }
        used_permits++;
        notify();

    }

    public synchronized void release() throws InterruptedException{
        while(used_permits == 0) {
            wait();
        }
        used_permits--;
        notify();
    }
}
