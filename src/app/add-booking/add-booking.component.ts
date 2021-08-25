import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';
import { BookingDto } from '../model/bookingDto';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {

  constructor(private bookingService:BookingService,private router:Router) { }
  booking:BookingDto=new BookingDto();
  b:any;
  bookingId:number=0;
  ngOnInit(): void {
  }
  saveBooking()
  {
    this.bookingService.createBooking(this.booking).subscribe(data=>{
      this.b=data;
      this.bookingService.setBookingId(this.b.bookingId);
      console.log(data);
     
    }
    );
   
  }
  goToaddPassenger()
  {
       this.router.navigate(['/addPassenger']);
  }
  onSubmit()
  {
    console.log(this.booking);
    this.saveBooking();

  }
home(){
  this.router.navigate(['/bookinghome']);
}
}
