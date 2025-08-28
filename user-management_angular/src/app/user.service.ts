import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  url = 'http://localhost:8888';

  fetchUser() {
    return this.http.get(this.url + '/getAllUsers');
  }

  deleteUser(id:number){
    return this.http.delete(this.url+"/deleteUserById/"+id) 
  }

  postMobile(body:any){
    return this.http.post(this.url+"/addnewuser", body)
  }

  putMobile(id:number,body:any){
    return this.http.put(this.url+"/updateUserById/"+id, body)
  }
}
