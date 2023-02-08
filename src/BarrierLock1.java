

public class BarrierLock1 {
    static int MAX_COUNT = 5;
    int count = 0;
    //if count = maxCount then only allow all threads
    //

    public synchronized void passThroughBarrier() throws InterruptedException {

        count++;
        while(count < MAX_COUNT) {
            wait(); //thread which woke up from notifyall will stuck in loop since count is set to 0
        }
        if(count == MAX_COUNT) {
            count = 0;
            notifyAll();
        }
    }

}
