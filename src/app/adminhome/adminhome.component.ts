import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  userId:any;
  userType:any;
  searchUserId:number = 0;
  constructor(private router:Router,private services:UsersService) { }

  ngOnInit(): void {
    this.userId = this.services.getId();
    this.userType = this.services.getType();
  }
  logout()
  {
    this.router.navigate(['']);
  }
  toAirport()
  {
    this.router.navigate(['/airporthome']);
  }
  toFlights()
  {
    this.router.navigate(['/flighthome']);
  }
  toBooking()
  {
    this.router.navigate(['/bookinghome']);
  }
  toScheduledFlight()
  {
    this.router.navigate(['/scheduledflightHome-Page']);
  }
  search()
  {
    if(this.searchUserId == 0)
    {
      this.router.navigate(['/userlist']);
    }
    else
    {
      this.services.search(this.searchUserId);
      this.router.navigate(['/userdetails']);
    }
  }
}
