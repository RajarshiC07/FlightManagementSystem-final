import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { ScheduledFlight } from '../model/scheduledFlight';

@Component({
  selector: 'app-viewby-flightnumber',
  templateUrl: './viewby-flightnumber.component.html',
  styleUrls: ['./viewby-flightnumber.component.css']
})
export class ViewbyFlightnumberComponent implements OnInit {

  scheduleflight : any;
  
  public flightnumber: any;

  constructor(private service: ScheduledFlightService,private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    
    //this.scheduledflight=new ScheduledFlight();
    
    }


  onClick()
  {
    this.service.getbyflightnumber(this.flightnumber).subscribe(data =>{
    this.scheduleflight=data;
  });
}


}
