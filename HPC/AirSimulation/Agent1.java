
/* Agent1 class
 *
 * AirSimulation exercise on multi-threading
 *
 * AM
 */

public class Agent1 extends Thread implements Agent
{
   // reference to the Aircraft
   private Aircraft aircraft;

   // Agent1 constructor
   public Agent1(Aircraft aircraft)
   {
      this.aircraft = aircraft;
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
         while (seatIt.next() != null);
      }
      catch (Exception e)
      {
         return;
      }

      Customer c = new Customer();
      if (!c.isOver70() || !seatIt.isNearEmergencyExit())  seatIt.place(c);
   }
}

