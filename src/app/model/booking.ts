import { Airport } from "./airport";
import { Flight } from "./flight";
import { Passenger } from "./passenger";
import { Schedule } from "./schedule";
import { ScheduledFlight } from "./scheduledFlight";
import { Users } from "./Users";

export class Booking{
   
        bookingId:number=0;
        userId:Users=new Users();
        bookingDate: Date=new Date();
        passengerList: Passenger[]=[];
        ticketCost:number=0;
        scheduledFlight:ScheduledFlight=new ScheduledFlight();
        noOfPassengers:number=0;
}