import { Airport } from "./airport";

export class Schedule{
        scheduleId : number=0;
        sourceAirport :Airport= new Airport();
        destinationAirport : Airport=new Airport();
        arrivalTime : Date =new Date();
        departureTime : Date=new Date();
   
}