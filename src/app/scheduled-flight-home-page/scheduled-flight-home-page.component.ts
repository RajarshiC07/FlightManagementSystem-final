import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { UsersService } from '../services/users.service';
@Component({
  selector: 'app-scheduled-flight-home-page',
  templateUrl: './scheduled-flight-home-page.component.html',
  styleUrls: ['./scheduled-flight-home-page.component.css']
})
export class ScheduledFlightHomePageComponent implements OnInit {

  constructor(private route: Router, private router: ActivatedRoute,private userservices:UsersService) { }

  ngOnInit(): void {
  }

  onclick()
  {
    this.route.navigate(['/ScheduledFlights']);
  }

  gotoAddSchedule()
  {
    this.route.navigate(['/addScheduleFlights']);
  }

  gotoviewbyflightnumber()
  {
    this.route.navigate(['/viewScheduledFlightsByFlightNumber']);
  }

  gotoviewbyairport()
  {
    this.route.navigate(['/viewbyScheduledFlightsByAirport']);
  }
  home()
  {
      this.route.navigate(['/adminhome']);
  }

}
