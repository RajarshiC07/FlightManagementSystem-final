import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-delete-user-confirmation',
  templateUrl: './delete-user-confirmation.component.html',
  styleUrls: ['./delete-user-confirmation.component.css']
})
export class DeleteUserConfirmationComponent implements OnInit {

  userType:any;
  message:any;
  id:any
  userId:any;
  val:any;
  constructor(private service:UsersService,private router:Router) { }

  ngOnInit(): void {
    this.userType = this.service.getType();
    this.id = this.service.getdelId();
    this.userId = this.service.getId();
    this.val = (this.userId == this.id);
    if(this.userType.match("Admin"))
    {
        this.message = "Are you sure you want to delete this user?";
    }
    else if(this.userType.match("Customer"))
    {
      this.message = "Are you sure you want to delete your account?";
    }
  }
  goBack()
  {
    if(this.userType.match("Admin"))
    {
      this.router.navigate(['/userlist']);
    }
    else if(this.userType.match("Customer"))
    {
      this.router.navigate(['/userhome']);
    }
  }
  delete()
  {
    if(this.userType.match("Admin"))
    {
      if(this.id == this.userId)
      {
         this.service.deletebyId(this.id).subscribe((data)=>{this.message = data;this.router.navigate([''])});
       }
     else
      {
         this.service.deletebyId(this.id).subscribe((data)=>{this.message = data;this.router.navigate(['/userlist']);});
        
      }
    }
    else if(this.userType.match("Customer"))
    {
      this.service.deletebyId(this.userId).subscribe((data)=>{this.message = data;this.router.navigate([''])});
    }
  }
}
