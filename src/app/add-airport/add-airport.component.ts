import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportServiceService } from '../services/airport-service.service';
import { Airport } from '../model/airport';
@Component({
  selector: 'app-add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent implements OnInit {
  airport: Airport = new Airport();
  submitted=false;
  constructor(private airportService: AirportServiceService, 
    private router: Router) { }

  ngOnInit(): void {
  }
  addAirport(){
    this.airportService.addAirport(this.airport).subscribe( data =>{
    console.log(data);
    this.goToAirportList();
    },
    error => console.log(error));
  }

  goToAirportList(){
    this.router.navigate(['/airports']);
  }
  onSubmit(){
    this.addAirport();
    this.submitted=true;
  }
  goToHome(){
    this.router.navigate(['airporthome']);
  }
}

  