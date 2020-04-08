import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../environments/environment'
import { Observable } from 'rxjs';
import { NewUser } from './new-user'
import { User } from './user'

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  gatewayURL: string = environment.apiUrl + "/users"

  constructor(private http: HttpClient) { }

  getUser(){
    return this.http.get(this.gatewayURL + "?id=Jake");
  }

  createUser(newUser: NewUser) {
    return this.http.post(this.gatewayURL, newUser)
  }
}
