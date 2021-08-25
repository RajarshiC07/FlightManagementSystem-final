import { Component, OnInit } from '@angular/core';
import { Airport } from '../model/airport';
import { AirportServiceService } from '../services/airport-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';
import { analyzeAndValidateNgModules } from '@angular/compiler';
@Component({
  selector: 'app-modify-airport',
  templateUrl: './modify-airport.component.html',
  styleUrls: ['./modify-airport.component.css']
})
export class ModifyAirportComponent implements OnInit {
  airportCode:any;
  updated=false;
 airport:any;
  constructor(private airportService: AirportServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.airportCode=this.route.snapshot.params['airportCode'];
  this.airportService.getAirportByCode(this.airportCode).subscribe(data => {
    this.airport=data;
  }, 
  error=>console.log(error));
  }
  modifyAirport(){
    this.airportService.modifyAirport(this.airportCode, this.airport).subscribe( data =>{
    console.log(data);
    this.airport=new Airport();
    this.goToAirportList();
    },
    error => console.log(error));
  }

  
  onSubmit(){
  this.airportService.modifyAirport(this.airportCode, this.airport).subscribe(data =>{
    this.goToAirportList();
    this.updated=true;
  },
  error=>console.log(error));
}


goToAirportList(){
  this.router.navigate(['/airports']);
}
}
 
