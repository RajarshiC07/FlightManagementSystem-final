import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../model/flight';
import { FlightListComponent } from '../flight-list/flight-list.component';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  flight: Flight = new Flight();
  added=false;
  constructor(private flightService: FlightService, 
    private router: Router) { }
  ngOnInit(): void {
  }
  addFlight(){
    this.flightService.addFlight(this.flight).subscribe( data =>{
    console.log(data);
    this.goToFlightList();
    
    },
    error => console.log(error));
  }

  goToFlightList(){
    this.router.navigate(['/flights']);
  }
  onSubmit(){
    this.addFlight();
    this.added=true;
  }
}
