import { Component } from '@angular/core';
import { MatIconRegistry } from "@angular/material/icon";
import { DomSanitizer } from "@angular/platform-browser";
import { AuthService } from './services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'stocks 4 Fun';
  auth: boolean;
  verified: boolean = false;

  constructor(private matIconRegistry: MatIconRegistry, private domSanitizer: DomSanitizer, private authService: AuthService, private router: Router) {    
    this.matIconRegistry.addSvgIcon(
      "logo",
      this.domSanitizer.bypassSecurityTrustResourceUrl("assets/images/logo.svg")
    );
  }

  ngOnInit() {
    this.auth = this.authService.isAuthenticated();
    console.log("app bar reloaded " + this.auth);
       
  }

  logout(): void {
    localStorage.removeItem("token");
    this.router.navigate(["/"])
    window.location.reload()
  }
}
