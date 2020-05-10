import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service'
import { Router } from '@angular/router'
@Injectable({
  providedIn: 'root'
})
export class RolesGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router) { }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const token = this.auth.decodeToken()
    if (!this.auth.isAuthenticated() ||  token['role'] != "admin") {
      this.router.navigateByUrl('login');
      return false
    }
    return true;
  }
  
}
