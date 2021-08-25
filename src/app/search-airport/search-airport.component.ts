import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from '../model/airport';
import { AirportServiceService } from '../services/airport-service.service';

@Component({
  selector: 'app-search-airport',
  templateUrl: './search-airport.component.html',
  styleUrls: ['./search-airport.component.css']
})
export class SearchAirportComponent implements OnInit {
  airportCode: string="";
  airport: Airport=new Airport();
  constructor(private route: ActivatedRoute,
    private airportService: AirportServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.airportCode=this.route.snapshot.params['airportCode'];
    this.airport=new Airport();
    this.airportService.getAirportByCode(this.airportCode).subscribe(data =>{
      this.airport=data;
    })
  }
  goToAirportList(){
    this.router.navigate(['/airports']);
  }
  goToHome(){
    this.router.navigate(['airporthome']);
  }
}


 