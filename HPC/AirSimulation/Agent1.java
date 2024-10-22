
/* Agent1 class
 *
 * AirSimulation exercise on multi-threading
 *
 * AM
 */

import java.util.concurrent.Semaphore;

public class Agent1 extends Thread implements Agent
{
   // reference to the Aircraft
   private Aircraft aircraft;
   private Semaphore sem;


   // Agent1 constructor
   public Agent1(Aircraft aircraft, Semaphore sem)
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

