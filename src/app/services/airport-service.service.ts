import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';

@Injectable({
  providedIn: 'root'
})
export class AirportServiceService {
  private baseURL = "http://localhost:9000/Airports";
  constructor(private httpClient:HttpClient) { }

  getAirportList():Observable<Airport[]>{
    return this.httpClient.get<Airport[]>(this.baseURL);
  }
  addAirport(airport:Airport):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,airport);
  }

  getAirportByCode(airportCode: string): Observable<Airport>{
    return this.httpClient.get<Airport>(`${this.baseURL}/${airportCode}`);
  }

  modifyAirport(airportCode: string, airport: Airport): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${airportCode}`, airport);
  }
  deleteAirport(airportCode: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${airportCode}`);
  }
}

  