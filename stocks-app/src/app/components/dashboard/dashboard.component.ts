import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmailService } from '../../services/email/email.service';
import { VerifyEmail } from '../../interfaces/verify-email';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  tokenInfo: Object;



  constructor(public auth: AuthService, private emailService: EmailService) { }

  ngOnInit(): void {
    this.tokenInfo = this.auth.decodeToken()
    console.log(this.tokenInfo);
  }

  verifyEmail(): void {
    const email: VerifyEmail = {
      id: this.tokenInfo['user_id'],
      email: this.tokenInfo['email']
    }
    console.log(email);
    this.emailService.sendVerifyEmail(email).subscribe(
      data => console.log(data),
      error => console.log(error)
    )
  }
}
