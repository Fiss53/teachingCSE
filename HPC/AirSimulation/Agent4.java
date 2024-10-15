public class Agent4 extends Thread implements Agent{


    private Aircraft aircraft;

    // Agent4 constructor
    public Agent4(Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }
    public void run()
    {
        Aircraft.SeatIterator seatIt = this.aircraft.iterator();
        try
        {
            while (true)
            {
                Customer c = seatIt.next();
                if (c != null)
                {
                    seatIt.remove();
                    seatIt.place(c);
                }
            }
        }
        catch (Exception e)
        {
            return;  // iterations are over
        }
    }
}
