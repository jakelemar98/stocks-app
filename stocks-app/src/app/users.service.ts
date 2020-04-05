import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../environments/environment'
@Injectable({
  providedIn: 'root'
})
export class UsersService {

  gatewayURL: string = environment.apiUrl + "/users"

  constructor(private http: HttpClient) { }

  getUser(){
    return this.http.get(this.gatewayURL + "?symbol=Jake");
  }
}
