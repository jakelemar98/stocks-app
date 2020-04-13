import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string = localStorage.getItem('token')

  constructor(public jwtHelper: JwtHelperService) { }

  public isAuthenticated(): boolean {
    return !this.jwtHelper.isTokenExpired(this.token)
  }

  public decodeToken(): Object {
    return this.jwtHelper.decodeToken(this.token)
  }
}
