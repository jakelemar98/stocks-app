import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(public jwtHelper: JwtHelperService, private router: Router) { }

  public isAuthenticated(): boolean {
    const token: string = localStorage.getItem('token')
    
    return !this.jwtHelper.isTokenExpired(token)
  }

  public decodeToken(): Object {
    const token: string = localStorage.getItem('token')

    return this.jwtHelper.decodeToken(token)
  }

  public decideRoute(): void {
    const token: string = localStorage.getItem('token')

    const tokenData: Object = this.jwtHelper.decodeToken(token)
    
    if (tokenData["role"] === "admin") {
      this.router.navigate(["admin"])
    } else {
      this.router.navigate(["dashboard"])
    }
    
  }
}
