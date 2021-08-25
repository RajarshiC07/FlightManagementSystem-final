import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BookingDto } from '../model/bookingDto';
import { PassengerDto } from '../model/passengerDto';
import { Booking } from '../model/booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private baseURL="http://localhost:9000";
  bookingId:any;
  setBookingId(id:any){
    this.bookingId=id;
  }
  getBookingId():number{
    return this.bookingId;
  }
  constructor(private httpClient:HttpClient) { }

  createBooking(bookingDto:BookingDto):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/addBooking`,bookingDto);
  }

  createPassenger(passengerDto:PassengerDto):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/addPassenger`,passengerDto);
  }

  confirmBooking(bookingId:number):Observable<Object>{
    return this.httpClient.get(`${this.baseURL}/ConfirmBooking/${bookingId}`);
  }

  removeBooking(bookingId:number){
    return this.httpClient.delete(`${this.baseURL}/deleteBookingById/${bookingId}`);
  }

  editBooking(booking:Booking):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/modifyBooking`,booking);
  }

  getAllBooking():Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL}/viewAllBookings`);
  }

  getBookingById(bookingId: number):Observable<Booking>{
    return this.httpClient.get<Booking>(`${this.baseURL}/bookingById/${bookingId}`);
  }

}
