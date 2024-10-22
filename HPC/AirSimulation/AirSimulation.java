
/* AirSimulation class
 *
 * AirSimulation exercise on multi-threading
 *
 * AM
 */

import java.util.concurrent.Semaphore;

public class AirSimulation
{
   public static void main(String[] args)
   {
      Aircraft aircraft = new Aircraft();
      Agent1 agent1 = new Agent1(aircraft);
      Agent2 agent2 = new Agent2(aircraft);
      //Agent3 agent3 = new Agent3(aircraft);
      //Agent4 agent4 = new Agent4(aircraft);
      final Semaphore sem = new Semaphore(1);
      agent1.start();
      //agent2.start();
      //agent3.start();
      //agent4.start();
      System.out.println(aircraft);
      System.out.println(aircraft.cleanString());
   }
}

