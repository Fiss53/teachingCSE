
/* Agent2 class
 *
 * AirSimulation exercise on multi-threading
 *
 * AM
 */

public class Agent2 extends Thread implements Agent
{
   // reference to the Aircraft
   private Aircraft aircraft;

   // Agent2 constructor
   public Agent2(Aircraft aircraft)
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
      if (!(c.needsAssistence() && seatIt.isNearEmergencyExit()))  seatIt.place(c);
   }
}

