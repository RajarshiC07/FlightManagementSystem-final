import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../model/flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private baseURL = "http://localhost:9000/flight";
  constructor(private httpClient:HttpClient) { }

  getFlightList():Observable<Flight[]>{
    return this.httpClient.get<Flight[]>(`${this.baseURL}`);
  }
  addFlight(flight:Flight):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,flight);
  }

  getFlightByNumber(flightNumber: number): Observable<Flight>{
    return this.httpClient.get<Flight>(`${this.baseURL}/${flightNumber}`);
  }

  modifyFlight(flightNumber: number, flight: Flight): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${flightNumber}`, flight);
  }
  deleteFlight(flightNumber: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${flightNumber}`);
  }
}
