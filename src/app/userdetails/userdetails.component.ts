import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from '../model/Users';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

  userId:any;
  userType:any;
  public user:Users = new Users();
  constructor(private router:Router,private services:UsersService) { }

  ngOnInit(): void {
    this.services.getById().subscribe((data)=>this.user = data);
    this.userId = this.services.getId();
    this.userType = this.services.getType();
  }
  home()
  {
    if(this.services.getType().match("Admin"))
    {
      this.router.navigate(['/adminhome']);
    }
    else if(this.services.getType().match("Customer"))
    {
      this.router.navigate(['/userhome']);
    }
  }
  back()
  {
    this.router.navigate(['/userlist']);
  }
}
