import java.util.concurrent.Semaphore;

public class Agent3 extends Thread implements Agent
{
    // reference to the Aircraft
    private Aircraft aircraft;
    private int threshold = 6;
    private Semaphore sem;
    // Agent3 constructor
    public Agent3(Aircraft aircraft,Semaphore sem)
    {
        this.aircraft = aircraft;
        this.sem = sem;
    }

    // everytime it is invoked, it creates and places one Customer
    @Override
    public void run()
    {
        while (!this.aircraft.isFull()) {
            putClient();
        }
    }

    private void putClient() {
        Aircraft.SeatIterator seatIt = this.aircraft.iterator();
        try
        {
            sem.acquire();
            Customer cFound = seatIt.next();
            while (cFound != null)
            {
                if(cFound.getFlyerLevel() < threshold) //search for a seat with someone under the threshold
                {
                    seatIt.remove();
                    Customer c = new Customer();
                    while(c.getFlyerLevel() < threshold){// search for a customer above the threshold
                        c = new Customer();
                    }
                    seatIt.place(c);
                    sem.release();
                }
                cFound = seatIt.next();
            }

        }
        catch (Exception e)
        {
            return;
        }
    }
}

