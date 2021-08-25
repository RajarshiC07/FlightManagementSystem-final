import { HttpClient } from '@angular/common/http';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, RequiredValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { Users } from '../model/Users';
import { UsersService } from '../services/users.service';
import {forbiddenNameValidator} from '../model/userValidator';
import {forbiddenPhoneValidator} from '../model/userValidator';
import {forbiddenMailValidator} from '../model/userValidator';
import {forbiddenTypeValidator} from '../model/userValidator';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 
  user:Users = new Users();
  sample:any;
  errors:any;
  err:any;
  validity:number = 0;
  constructor(private router:Router,private service:UsersService,private fb:FormBuilder) { }
  nameForm = this.fb.group({
      userName:['',[forbiddenNameValidator]],
     
  });
  passwordForm = this.fb.group(
    {
      'userPassword':['']
    }
  );
  emailForm = this.fb.group(
    {
      'userEmail':['',[forbiddenMailValidator]]
    }
  );
  phoneForm = this.fb.group(
    {
      'userPhone':['',[forbiddenPhoneValidator]]
    }
  );
  typeForm = this.fb.group(
    {
      'userType':['',[forbiddenTypeValidator]]
    }
  );
  ngOnInit(): void {
  }

  routing(user:Users)
  {
    if(user.userType.match('Admin'))
    {
       this.router.navigate(['/adminhome']);
    }
    else if(user.userType.match('Customer'))
    { 
       this.router.navigate(['/userhome']);    
    }
  }
  addUser()
  {
    this.service.addUser(this.user).subscribe((data)=>{this.sample = data
    this.service.setCreds(this.sample.userId,this.sample.userType);
    this.routing(this.sample);});
  }
  register()
  {
    this.sample = {userType:this.typeForm.controls['userType'].value,
                  userName:this.nameForm.controls['userName'].value, 
                  userPassword:this.passwordForm.controls['userPassword'].value,
                  userPhone:this.phoneForm.controls['userPhone'].value,
                  userEmail:this.emailForm.controls['userEmail'].value };
    this.user = this.sample;
    this.addUser();    
  
  }
  login()
  {
    this.router.navigate(['']);
  }
}
