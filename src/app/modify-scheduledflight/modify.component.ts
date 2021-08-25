import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../model/flight';
import { Schedule } from '../model/schedule';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { ScheduledFlight } from '../model/scheduledFlight';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit {

  scheduledflight : any;
  public flightnumber: any;

  constructor(private service : ScheduledFlightService, private router: Router) { }

  ngOnInit(): void {
    this.flightnumber=this.service.getId();
    this.service.getbyscheduledFlightId(this.flightnumber).subscribe(data =>
      {
        this.scheduledflight=data;
      }, error =>console.log(error));
  }

  public modifysflight()
  {
    this.service.updateNow(this.flightnumber,this.scheduledflight).subscribe(data => {
      console.log(data);
      this.scheduledflight=new ScheduledFlight();
      this.goToScheduledFlightList();
    }, error => console.log(error));
  }

  onSubmit(){
    this.service.updateNow(this.flightnumber,this.scheduledflight).subscribe(data => {
      this.goToScheduledFlightList();
    }, error => console.log(error));
  }

  goToScheduledFlightList()
  {
    this.router.navigate(['/ScheduledFlights']);
  }

}
