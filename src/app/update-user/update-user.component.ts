import { Component, OnInit } from '@angular/core';
import { UsersService } from '../services/users.service';
import { Users } from '../model/Users';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  user:Users = new Users();
  updatedUser:Users = new Users();
  updateUserId:any;
  userId:any;
  userType:any;
  value:any;
  constructor(private route:Router,private services:UsersService) { }

  ngOnInit(): void {
      this.userId = this.services.getId();
      this.userType = this.services.getType();
      this.services.getById().subscribe((data) => this.user = data);
  }
  submit()
  {
        this.services.update(this.user).subscribe((data) => {
        this.user = data;
        this.check();
        });
  }
  check()
  {
    
	  if(this.userId.toString().match(this.user.userId.toString()))
    {
       this.services.setCreds(this.userId,this.user.userType);
       this.userType = this.services.getType();
     }
     if(this.services.getType().match('Admin'))
     {
         this.goToList();
     }
     else if(this.services.getType().match('Customer'))
     {
          this.goToHome();
     }
  }
  goToList()
  {
    this.route.navigate(['/userlist']);
  }
  goToHome()
  {
    this.route.navigate(['/userhome']);
  }
  goToDetails()
  {
    this.route.navigate(['/userdetails']);
  }
  home()
  {
   if(this.userType.match("Admin"))
  {
      this.route.navigate(['/adminhome']);
  }
  else if(this.userType.match("Customer"))
  {
     this.route.navigate(['/userhome']);
  }
 }
}
