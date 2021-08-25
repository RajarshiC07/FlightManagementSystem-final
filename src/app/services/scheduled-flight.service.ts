import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduledFlight';
import { ScheduledFlightDTO } from '../model/ScheduledFlightDTO';

@Injectable({
  providedIn: 'root'
})
export class ScheduledFlightService {
  searchId:any;
  private baseURL="http://localhost:9000";

  constructor(private http: HttpClient) { }

  setId(id:any)
  {
    this.searchId = id;
  }
  getId():number
  {
    return this.searchId;
  }
  public addNow(ScheduledFlightDTO: ScheduledFlightDTO):Observable<Object>
  {
    return this.http.post(`${this.baseURL}/addScheduleFlights`,ScheduledFlightDTO);
  }

  public getbyAirport(sourceAirport: string, destinationAirport: string, date: string): Observable<ScheduledFlight>
  {
    return this.http.get<ScheduledFlight>(this.baseURL+"/viewScheduledFlightsByAirport/"+sourceAirport+"/"+destinationAirport+"/"+date);
  }

  public getbyflightnumber(flightNumber: number): Observable<ScheduledFlight>
  {
    return this.http.get<ScheduledFlight>(`${this.baseURL}/viewScheduledFlightsByFlightNumber/${flightNumber}`);
  }
  public getbyscheduledFlightId(scheduledFlightId:number):Observable<ScheduledFlight>
  {
    return this.http.get<ScheduledFlight>(this.baseURL+"/viewScheduledFlightsById/"+scheduledFlightId);
  }
  public getallflights(): Observable<ScheduledFlight[]>
  {
    return this.http.get<ScheduledFlight[]>(this.baseURL+"/ScheduledFlights");
  }

  public updateNow(flightNumber: number, scheduledflight: ScheduledFlight): Observable<Object>
  {
    return this.http.put(`${this.baseURL}/modifyFlightsByFlightNumber/${flightNumber}`, scheduledflight);
  }

  public removebyid(scheduledflightid: number): Observable<Object>
  {
    return this.http.delete(`${this.baseURL}/deleteFlightsByScheduledFlightId/${scheduledflightid}`);
  }
}
