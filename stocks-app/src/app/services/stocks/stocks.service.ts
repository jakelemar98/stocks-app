import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment'
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Watcher } from 'src/app/interfaces/watcher';

@Injectable({
  providedIn: 'root'
})
export class StocksService {

  gatewayURL: string = environment.apiUrl + "/stocks/"

  token: string = localStorage.getItem('token')
  
  headers_object: Object = new HttpHeaders({
    'Authorization': "Bearer "+ this.token,
    'Content-Type': 'application/json'
  });

  httpOptions: Object = {
    headers: this.headers_object,
  };

  constructor(private http: HttpClient) { }

  getStockMatches(){
    return this.http.get(this.gatewayURL + "matches?symbol=penn");
  }

  getStockPrice(symbol){
    return this.http.get(this.gatewayURL + "price?symbol=" + symbol)
  }

  getTimeSeries(time: string, symbol: string){
    return this.http.get(this.gatewayURL + "timeSeries?symbol=" + symbol + "&time=" + time).pipe(catchError(this.handleError))
  }

  addStockWatcher(symbol: string){
  const watcher: Watcher = {
    symbol: symbol,
    id: ""
  }
    return this.http.post(this.gatewayURL + "watchers", watcher, this.httpOptions).pipe(catchError(this.handleError))
  }

  getWatchingData(): Observable<any> {
    return this.http.get(this.gatewayURL + "watchers", this.httpOptions).pipe(catchError(this.handleError))
  }

  deleteStockWatcher(symbol: string): Observable<any> {
    return this.http.put(this.gatewayURL + "watchers", symbol, this.httpOptions).pipe(catchError(this.handleError))
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
