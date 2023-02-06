public class ReadWriteLock {
    int max_reader_threads;
    int reader_thread_count;
    boolean isWriteLocked = false;
    int readers = 0;

    //aquireReadLock
    //releaseReadLock
    //aquireWriteLock
    //releaseWriteLock
    /**
     * no read lock should enter into while writer thread writing in critical section
     * read thread can read if there is no writer thread
     * writer thread should not enter into critical section if there is reader thread reading in critical section
     */

    //create one semaphore for writer purpose
    //take some count as x readers
    public ReadWriteLock (int max_reader_threads, int reader_thread_count) {
    this.max_reader_threads = max_reader_threads;
    this.reader_thread_count = reader_thread_count;
    }

    public synchronized void aquireReadLock() throws InterruptedException {
        while(isWriteLocked) {
            wait();
        }
        readers++;

    }

    public synchronized void aquireWriteLock() throws InterruptedException {
        while (readers != 0 || isWriteLocked) {
            wait();
        }
        isWriteLocked = true;
    }

    public synchronized  void releaseReadLock() throws InterruptedException {
        readers--;
        notify();
    }

    public synchronized void releaseWriteLock() throws InterruptedException {
        isWriteLocked = true;
        notify();

    }


}
