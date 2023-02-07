public class UniSexLock {
    //there cannot be men and women in the bathroom at the same time
    //there should not be more than three employees in the bathroom

    //common variable 3

    int male_count = 0;
    int female_count = 0;
    int total_count = 0;

    public synchronized  void releaseMaleLock() throws InterruptedException {
        male_count--;
        notify();

    }
    public synchronized  void aquireMaleLock() throws InterruptedException{
        while(female_count >0 || male_count >=3) {
            wait();
        }
        male_count++;

    }
    public synchronized  void aquireFemaleLock ()throws InterruptedException{
        while (male_count > 0 || female_count >= 3) {
            wait();
        }
        female_count++;

    }
    public synchronized  void releaseFemaleLock() throws InterruptedException{
        female_count--;
        notify();

    }

}
