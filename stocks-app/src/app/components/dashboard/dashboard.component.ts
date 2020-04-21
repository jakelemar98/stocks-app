import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmailService } from '../../services/email/email.service';
import { MatDialogRef, MatDialog } from '@angular/material/dialog';
import { VerifyDialogComponent } from './verify-dialog/verify-dialog.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  tokenInfo: Object;
  response: Object;
  verifyDialog:  MatDialogRef<VerifyDialogComponent>

  constructor(public auth: AuthService, private emailService: EmailService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.tokenInfo = this.auth.decodeToken()
  }

  verifyEmail(): void {
    this.emailService.sendVerifyEmail().subscribe(
      data => {
        this.response = data;
        this.verifyDialog = this.dialog.open(VerifyDialogComponent, {
          width: "250px",
          data: {code: 12345}
        });
      },
      error => console.log(error)
    )
  }
}
