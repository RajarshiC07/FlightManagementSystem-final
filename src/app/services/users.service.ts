import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Users } from '../model/Users';
import {Observable} from 'rxjs';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private _url = "http://localhost:9000/";
  public userType:any;
  public userId:any;
  public searchId:any;
  public deleteid:any;
  constructor(private http:HttpClient) { }
  setCreds(userId:any,userType:any)
  {
    this.userId = userId;
    this.userType = userType;
  }
  setdelId(id:any)
  {
    this.deleteid = id;
  }
  getdelId():number
  {
    return this.deleteid;
  }
  getId():number
  {
    return this.userId;
  }
  getType():String
  {
    return this.userType;
  }
  Login(userId:string,password:string)
  {
    
    return this.http.get<string[]>(this._url+"Login/"+userId+"/"+password,{responseType:'text' as 'json'});
  }
  addUser(user:Users)
  {
    return this.http.post(this._url+"addUser",user);
  }
  errorHandler(error:HttpErrorResponse)
  {
    return Observable.throw(error.message);
  }
  getAll()
  {
    return this.http.get<Users[]>(this._url+"viewallUsers");
  }
  search(searchId:number)
  {
    this.searchId = searchId;
    return this.searchId;
  }
  getById()
  {
    return this.http.get<Users>(this._url+"viewbyId/"+this.searchId);
  }
  deletebyId(id:any)
  {
    return this.http.delete<String[]>(this._url+"deletebyId/"+id,{responseType:'text' as 'json'});
  }
  update(user:Users)
  {
    return this.http.put<Users>(this._url+"updateUser",user);
  }
}