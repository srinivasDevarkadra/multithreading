

public class BarrierLock1 {
    static int MAX_COUNT = 5;
    int count = 0;
    //if count = maxCount then only allow all threads
    //

    public synchronized void passThroughBarrier() throws InterruptedException {

        count++;
        while(count < MAX_COUNT) {
            wait();
        }
        if(count == MAX_COUNT) {
            count = 0;
            notifyAll();
        }
    }

}
