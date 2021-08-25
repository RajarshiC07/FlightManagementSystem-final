import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent implements OnInit {
  booking:Booking=new Booking();
  constructor(private bookingService:BookingService, private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.booking.bookingId= this.route.snapshot.params['bookingId'];  
      this.bookingService.getBookingById(this.booking.bookingId ).subscribe(data => {
        this.booking = data;
      }, error => console.log(error));
    }
  
    updateBooking(){
      this.bookingService.editBooking(this.booking).subscribe( data =>{
        this.goToViewBookingList();
      });
    }
  
    goToViewBookingList(){
      this.router.navigate(['/viewAllBookings']);
    }
    home(){
      this.router.navigate(['/viewAllBookings']);
    }
  }
  