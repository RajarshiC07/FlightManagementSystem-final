import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Users } from '../model/Users';
import { UsersService } from '../services/users.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public message:string = 'Login';
  public userId:any;
  public password:any;
  public users:String[] = [];
  public validity = 0;
  constructor(private fb :FormBuilder,private service:UsersService,private route:Router) { }
  
  ngOnInit(): void {
  }
  routing(user:String[])
  {
    this.service.setCreds(this.userId,user.toString());
    if(user.toString().match('Admin'))
    {
       this.route.navigate(['/adminhome']);
    }
    else if(user.toString().match('Customer'))
    { 
       this.route.navigate(['/userhome']);    
    }
    else if(user.toString().match("no user"))
    {
        this.message = "Invalid Credentials";
        this.validity = 1;
    }
  }
  login(){
      this.service.Login(this.userId,this.password).subscribe((data)=>{this.users = data; this.routing(this.users)} );
    }
    goToRegister()
    {
      this.route.navigate(['/register']);
    }
  
}