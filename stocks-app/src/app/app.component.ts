import { Component } from '@angular/core';
import { MatIconRegistry } from "@angular/material/icon";
import { DomSanitizer } from "@angular/platform-browser";
import { AuthService } from './auth/auth.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'stocks 4 Fun';
  auth: boolean;

  constructor(private matIconRegistry: MatIconRegistry, private domSanitizer: DomSanitizer, private authService: AuthService) {    
    this.matIconRegistry.addSvgIcon(
      "logo",
      this.domSanitizer.bypassSecurityTrustResourceUrl("assets/images/logo.svg")
    );
  }

  ngOnInit() {
    this.auth = this.authService.isAuthenticated();
    console.log(this.auth);
    
  }
}
