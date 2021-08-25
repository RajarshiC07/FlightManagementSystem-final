import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';
import { PassengerDto } from '../model/passengerDto';

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css']
})
export class AddPassengerComponent implements OnInit {
 booking:any;
  constructor(private bookingService:BookingService,private router:Router) { }
  passenger:PassengerDto=new PassengerDto();
  ngOnInit(): void {
  }
 addPassenger(){
   this.bookingService.createPassenger(this.passenger).subscribe(data=>{
    this.booking=data; 
   
    },
    error => console.log(error)
    );
    window.location.reload();
  }
  
  onSubmit()
  {
    console.log(this.passenger);
    this.addPassenger();

  }
   goToConfirm(){
     //this.bookingService.setBookingId(this.booking.bookingId);
     this.router.navigate(['/ConfirmBooking']);
   }

   gotobooking(){
    this.router.navigate(['/addBooking']);
   }

 }

