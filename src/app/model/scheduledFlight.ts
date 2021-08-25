import { Flight } from "./flight";
import { Schedule } from "./schedule";

export class ScheduledFlight{
   
        scheduledFlightId : number=0;
        flight : Flight= new Flight();
        availableSeats : number=0;
        schedule : Schedule=new Schedule();
   
}