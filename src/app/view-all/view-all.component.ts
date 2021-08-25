import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Airport } from '../model/airport';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';
import { Flight } from '../model/flight';
import { Passenger } from '../model/passenger';
import { Schedule } from '../model/schedule';
import { ScheduledFlight } from '../model/scheduledFlight';
import { Users } from '../model/Users';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {
  bookings:Booking[]=[];
message:any;
  constructor(private bookingService:BookingService, private router:Router) {}
    private getBookings()
    {
      this.bookingService.getAllBooking().subscribe(data=>{
        this.bookings=data;
      })
    }

  ngOnInit(): void {
    this.getBookings();
  }

  updateBooking(bookingId:number)
  {
   this.router.navigate(["/modifyBooking/"+bookingId]);
  }
  deleteBooking(bookingId:number)
  {
   this.bookingService.removeBooking(bookingId).subscribe(data=>{  
  this.message=data;
  });
  window.location.reload();
  }

  bookingDetails(bookingId:number){
    this.router.navigate(["bookingById/"+bookingId]);
  }
  home(){
    this.router.navigate(['/bookinghome']);
  }
}
