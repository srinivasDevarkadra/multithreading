public class UberRideLock {
    //can ride all democrats or republicans
    //two democrats and two republicans
    //seated method to request for a seat in a car
    //drive once all drivers seated any on the thread can inform to start the drive

    //total seats occupied
    //republican count occupied
    //democrat count occupied
    //this solution is inefficient as provided in educative io as this solution assumes whoever comes first they are offered seat inside the car rather than waiting
    int total_seats_occupied = 0;
    int rep_seats_occupied = 0;
    int demo_seats_occupied = 0;

    public synchronized void republicanSeated() throws InterruptedException {
        while(total_seats_occupied > 4){
            wait();
        }
        while(total_seats_occupied > 2 && demo_seats_occupied >2) {
            wait();
        }
        while(total_seats_occupied == 3 && demo_seats_occupied == 1) {
            wait();
        }
        rep_seats_occupied++;
        total_seats_occupied++;
        if(total_seats_occupied == 4){
            total_seats_occupied = 0;
            rep_seats_occupied=0;
            demo_seats_occupied=0;
            notifyAll();
        }
    }

    public synchronized void democratSeated() throws InterruptedException {
        while (total_seats_occupied>4) {
            wait();
        }
        while(total_seats_occupied > 2 && rep_seats_occupied >2) {
            wait();
        }
        while(total_seats_occupied == 3 && rep_seats_occupied == 1) {
            wait();
        }
        demo_seats_occupied++;
        total_seats_occupied++;
        if(total_seats_occupied == 4) {
            total_seats_occupied = 0;
            rep_seats_occupied=0;
            demo_seats_occupied=0;
            notifyAll();
        }
    }


}
