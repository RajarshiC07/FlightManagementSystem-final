import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  message:any;
  constructor(private router:Router,private service:UsersService) { }
  userId:number = 0;
  userType:any;
  ngOnInit(): void {
      this.userId = this.service.getId();
      this.userType = this.service.getType();
  }
  logout()
  {
    this.router.navigate(['']);
  }
  toBooking()
  {
    this.router.navigate(['/bookinghome']);
  }
  toScheduledFlight()
  {
    this.router.navigate(['/viewbyScheduledFlightsByAirport']);
  }
  delete()
  {
    this.router.navigate(['/deleteuser']);
  }
  route()
  {
    this.router.navigate(['/login']);
  }
  update()
  {
    this.service.search(this.userId);
    this.router.navigate(['/update']);
  }
}
