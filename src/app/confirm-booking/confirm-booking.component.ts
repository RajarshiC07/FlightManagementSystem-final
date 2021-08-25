import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {
  booking:Booking=new Booking();
  bookingId:any;
  constructor(private bookingService:BookingService,private router:Router, private route: ActivatedRoute) { }
  bookings:Booking[]=[];
  ngOnInit(): void {
    
   this.bookingId=this.bookingService.getBookingId();
    this.bookingService.getBookingById(this.bookingService.getBookingId()).subscribe(data => {
      this.booking = data;
    }, error => console.log(error));
    this.booking.bookingId= this.route.snapshot.params['bookingId'];
  }
  onSubmit()
  {
    this.bookingService.confirmBooking(this.booking.bookingId).subscribe(data=>{
      console.log(data);
     
      },
      error => console.log(error)
      );      
    }

      gotoViewAll(){
        this.router.navigate(['/viewAllBookings']);
      }
      
  }