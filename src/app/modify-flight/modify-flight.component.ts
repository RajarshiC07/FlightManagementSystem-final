import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../model/flight';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-modify-flight',
  templateUrl: './modify-flight.component.html',
  styleUrls: ['./modify-flight.component.css']
})
export class ModifyFlightComponent implements OnInit {
  flightNumber!:number;
  flight:Flight=new Flight();
  constructor(private flightService: FlightService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.flightNumber=this.route.snapshot.params['flightNumber'];
  this.flightService.getFlightByNumber(this.flightNumber).subscribe(data => {
    this.flight=data;
  }, error=>console.log(error));
  }
  modifyFlight(){
    this.flightService.modifyFlight(this.flightNumber, this.flight).subscribe( data =>{
    console.log(data);
    this.flight=new Flight();
    this.goToFlightList();
    },
    error => console.log(error));
  }

  
  onSubmit(){
  this.flightService.modifyFlight(this.flightNumber, this.flight).subscribe(data =>{
    this.goToFlightList();
  },
  error=>console.log(error));
}


goToFlightList(){
  this.router.navigate(['/flights']);
}
}
