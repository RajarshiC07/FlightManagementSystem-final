import { Component, OnInit } from '@angular/core';
import { AirportServiceService } from '../services/airport-service.service';
import { Router } from '@angular/router';
import { Airport } from '../model/airport';
@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.css']
})
export class AirportListComponent implements OnInit {
  public airports: Airport[]=[];
  constructor(private airportService:AirportServiceService,
    private router: Router) { }

  ngOnInit(): void {
   this.getAirports();
  }
  private getAirports()
  {
    this.airportService.getAirportList().subscribe(data => {
      this.airports=data;
    });
  }
  modifyAirport(airportCode: string){
  this.router.navigate(['modify-airport', airportCode]);
  }
  deleteAirport(airportCode: string)
  {
    this.airportService.deleteAirport(airportCode).subscribe(data =>{
      console.log(data);
      window.location.reload();
    });
    window.location.reload();
  }
  viewAirport(airportCode: string){
    this.router.navigate(['search-airport',airportCode]);
  }
goToHome(){
  this.router.navigate(['airporthome']);
}
}

  
