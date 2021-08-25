import { Component, OnInit } from '@angular/core';
import { ScheduledFlightDTO } from '../model/ScheduledFlightDTO';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {


  scheduledflightdto : ScheduledFlightDTO= new ScheduledFlightDTO();

  constructor(private service : ScheduledFlightService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  public addFlight()
  {
    this.service.addNow(this.scheduledflightdto).subscribe((data) => {
      console.log(data);
    },
    error => console.log(error));
    window.location.reload();
  }

  goToScheduledFlightList()
  {
    this.router.navigate(['/ScheduledFlights']);
  }

  onSubmit()
  {
    this.addFlight();
  }
  home()
  {
    this.router.navigate(['/scheduledflightHome-Page']);
  }

}
