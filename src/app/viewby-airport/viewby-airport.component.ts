import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-viewby-airport',
  templateUrl: './viewby-airport.component.html',
  styleUrls: ['./viewby-airport.component.css']
})
export class ViewbyAirportComponent implements OnInit {

  scheduleflight : any;
  sourceAirport : any;
  destinationAirport : any;
  date : any;

  constructor(private service: ScheduledFlightService,private router: Router, private route: ActivatedRoute,private userservices:UsersService) { }

  ngOnInit(): void {
  }

  onSearch()
  {
    this.service.getbyAirport(this.sourceAirport,this.destinationAirport,this.date).subscribe(data =>{
      this.scheduleflight=data;
    });
  }
  home()
  {
    if(this.userservices.getType().match("Admin"))
    {
      this.router.navigate(['/scheduledflightHome-Page']);
    }
    else if(this.userservices.getType().match("Customer"))
    {
      this.router.navigate(['/userhome']);
    }
  }
}