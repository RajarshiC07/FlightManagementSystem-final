import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';
import { Users } from '../model/Users';
import { analyzeAndValidateNgModules } from '@angular/compiler';
@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  users:Users[] = [];
  message:any;
  userType:any;
  userId:any;
  constructor(private router:Router,private service:UsersService) { }

  ngOnInit(): void {
    this.service.getAll().subscribe((data)=>this.users = data);
    this.userType = this.service.getType();
    this.userId = this.service.getId();
  }
  details(id:any)
  {
    this.service.search(id);
    this.router.navigate(['/userdetails']);
  }
  delete(id:any)
  {
    this.service.setdelId(id);
    this.router.navigate(['/deleteuser']);
  }
  update(id:any)
  {
      this.service.search(id);
      this.router.navigate(['/update']);
 }
home()
{
      this.router.navigate(['/adminhome']);

 }

}

