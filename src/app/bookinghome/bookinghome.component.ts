import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';
@Component({
  selector: 'app-bookinghome',
  templateUrl: './bookinghome.component.html',
  styleUrls: ['./bookinghome.component.css']
})
export class BookinghomeComponent implements OnInit {

  userType:any;
  constructor( private router:Router,private userservices:UsersService) { }

  ngOnInit(): void {
    this.userType = this.userservices.getType();

  }
  addbooking(){
    this.router.navigate(['/addBooking']);
  }

  viewall(){
    this.router.navigate(['/viewAllBookings']);
  }
  home()
  {
   if(this.userType.match("Admin"))
    {
        this.router.navigate(['/adminhome']);
    }
    else if(this.userType.match("Customer"))
    {
       this.router.navigate(['/userhome']);
    }
  }
}