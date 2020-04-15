import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { environment } from './../../../environments/environment'
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

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

  getTimeSeries(time, symbol){
    return this.http.get(this.gatewayURL + "timeSeries?symbol=" + symbol + "&time=" + time).pipe(catchError(this.handleError))
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error.body}`);
    }
    // return an observable with a user-facing error message
    return throwError(`There seems to be a problem: ${error.error.body}`);
  };

}
