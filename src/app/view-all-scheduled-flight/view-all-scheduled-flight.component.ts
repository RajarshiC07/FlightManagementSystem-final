import { Component, OnInit } from '@angular/core';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { ScheduledFlight } from '../model/scheduledFlight';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-view-all-scheduled-flight',
  templateUrl: './view-all-scheduled-flight.component.html',
  styleUrls: ['./view-all-scheduled-flight.component.css']
})
export class ViewAllScheduledFlightComponent implements OnInit {

  
  public scheduledflights : ScheduledFlight[] = [];


  constructor(private service: ScheduledFlightService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getScheduledFlights();
  }
  private getScheduledFlights()
  {
    this.service.getallflights().subscribe(data =>{
      this.scheduledflights=data;
    });
  }
  
  viewbyFlightNumber(flightNumber: number)
  {
    this.router.navigate(['/viewFlightsByFlightNumber',flightNumber]);
  }

  modifyScheduledFlights(flightNumber: number)
  {
    this.service.setId(flightNumber);
    this.router.navigate(['/modifyFlightsByFlightNumber']);
  }

  deleteScheduledFlights(scheduledflightid: number)
  {
    this.service.removebyid(scheduledflightid).subscribe(data =>{
      console.log(data);
      window.location.reload();
    });
    window.location.reload();
  }

  gotoScheduledFlights()
  {
    this.router.navigate(['/ScheduledFlights']);
  }

}