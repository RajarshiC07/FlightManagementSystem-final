import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-view-by-id',
  templateUrl: './view-by-id.component.html',
  styleUrls: ['./view-by-id.component.css']
})
export class ViewByIdComponent implements OnInit {
  bookingId: number=0;
 booking: Booking=new Booking();
  constructor(private route: ActivatedRoute, private bookingService: BookingService, private router:Router) { }

  ngOnInit(): void {
    this.bookingId = this.route.snapshot.params['bookingId'];

    this.booking = new Booking();
    this.bookingService.getBookingById(this.bookingId).subscribe( data => {
      this.booking = data;
    });
  }
  home(){
    this.router.navigate(['/viewAllBookings']);
  }
}

