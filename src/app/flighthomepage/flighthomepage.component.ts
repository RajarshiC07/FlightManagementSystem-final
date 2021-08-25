import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flighthomepage',
  templateUrl: './flighthomepage.component.html',
  styleUrls: ['./flighthomepage.component.css']
})
export class FlighthomepageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
goToFlightList()
{
  this.router.navigate(['/flights']);
}

goToAddFlight()
{
  this.router.navigate(['/add-flight']);
}
home()
{
  this.router.navigate(['/adminhome']);
}

}
