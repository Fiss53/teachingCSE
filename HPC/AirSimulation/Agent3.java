public class Agent3 extends Thread implements Agent
{
    // reference to the Aircraft
    private Aircraft aircraft;
    private int threshold = 6;
    // Agent2 constructor
    public Agent3(Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }

    // everytime it is invoked, it creates and places one Customer
    @Override
    public void run()
    {
        if (this.aircraft.isFull())  return;
        Aircraft.SeatIterator seatIt = this.aircraft.iterator();
        try
        {
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
                }
                cFound = seatIt.next();
            }

        }
        catch (Exception e)
        {
            return;  // nothing done
        }
    }
}

