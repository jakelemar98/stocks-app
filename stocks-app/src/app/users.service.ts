import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  gatewayURL: string = "https://stocks4fun.com/users"

  constructor(private http: HttpClient) { }

  getUser(){
    return this.http.get(this.gatewayURL + "?symbol=Jake");
  }
}
