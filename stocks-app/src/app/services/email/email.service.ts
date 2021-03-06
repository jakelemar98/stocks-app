import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment'
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class EmailService {

  gatewayURL: string = environment.apiUrl + "/email/"
  
  token: string = localStorage.getItem('token')
  
  headers_object: Object = new HttpHeaders({
    'Authorization': "Bearer "+ this.token,
  });

  httpOptions: Object = {
        headers: this.headers_object,
  };

  constructor(private http: HttpClient) { }

  sendVerifyEmail() {
    return this.http.get(this.gatewayURL + "verify", this.httpOptions).pipe(catchError(this.handleError));
  }

  checkCode(code: number) {
    return this.http.get(this.gatewayURL + "code?value=" + code, this.httpOptions).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(error)
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
