import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../model/flight';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  flightNumber: number=0;
  flight: Flight=new Flight();
  constructor(private route: ActivatedRoute,
    private flightService: FlightService,
    private router: Router) { }

  ngOnInit(): void {
    this.flightNumber=this.route.snapshot.params['flightNumber'];
    this.flight=new Flight();
    this.flightService.getFlightByNumber(this.flightNumber).subscribe(data =>{
      this.flight=data;
    })
  }
  goToFlightList(){
    this.router.navigate(['/flights']);
  }
}
