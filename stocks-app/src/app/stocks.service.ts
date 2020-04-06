import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../environments/environment'
@Injectable({
  providedIn: 'root'
})
export class StocksService {

  gatewayURL: string = environment.apiUrl + "/stocks/"

  constructor(private http: HttpClient) { }

  getStockMatches(){
    return this.http.get(this.gatewayURL + "matches?symbol=penn");
  }

  getStockPrice(){
    return this.http.get(this.gatewayURL + "price?symbol=msft")
  }
}
