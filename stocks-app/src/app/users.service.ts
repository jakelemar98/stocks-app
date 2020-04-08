import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../environments/environment'
import { NewUser } from './new-user'
import { Login } from './login';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  gatewayURL: string = environment.apiUrl + "/users"

  constructor(private http: HttpClient) { }

  getUser(login: Login){
    console.log(login);
    
    return this.http.post(this.gatewayURL + "/login", login);
  }

  createUser(newUser: NewUser) {
    return this.http.post(this.gatewayURL + "/create", newUser)
  }
}
