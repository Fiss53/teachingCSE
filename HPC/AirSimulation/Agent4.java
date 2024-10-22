import java.util.concurrent.Semaphore;

public class Agent4 extends Thread implements Agent{


    private Aircraft aircraft;
    private Semaphore sem;

    // Agent4 constructor
    public Agent4(Aircraft aircraft, Semaphore sem)
    {
        this.aircraft = aircraft;
        this.sem = sem;
    }
    @Override
    public void run() {
        putClient();
    }
    public void putClient(){
        Aircraft.SeatIterator seatIt = this.aircraft.iterator();

        try {
            sem.acquire();
            while (true) {
                Customer c = seatIt.next();
                if (c != null) {
                    seatIt.remove();
                    seatIt.place(c);
                    sem.release();
                }
            }
        } catch (Exception e) {
            return;  // iterations are over
        }
    }
}

