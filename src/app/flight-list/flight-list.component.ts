import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../model/flight';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
 public flights: Flight[]=[];
  constructor(private flightService:FlightService,
    private router: Router) { }

  ngOnInit(): void {
   this.getFlights();
  }
  private getFlights()
  {
    this.flightService.getFlightList().subscribe(data => {
      this.flights=data;
    });
  }
  modifyFlight(flightNumber: number){
  this.router.navigate(['modify-flight', flightNumber]);
  }
  deleteFlight(flightNumber: number)
  {
    this.flightService.deleteFlight(flightNumber).subscribe(data =>{
      console.log(data);
    });
    window.location.reload();
  }
  viewFlight(flightNumber: number){
    this.router.navigate(['search-flight',flightNumber]);
  }
goToHome(){
  this.router.navigate(['flighthome']);
}
}
