import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { environment } from './../environments/environment'
import { NewUser } from './new-user'
import { Login } from './login';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  gatewayURL: string = environment.apiUrl + "/users"

  constructor(private http: HttpClient) { }

  getUser(login: Login){    
    return this.http.post(this.gatewayURL + "/login", login).pipe(catchError(this.handleError));
  }

  createUser(newUser: NewUser) {
    return this.http.post(this.gatewayURL + "/create", newUser).pipe(catchError(this.handleError))
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
