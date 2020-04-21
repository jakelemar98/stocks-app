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
  verified: Boolean;

  constructor(public auth: AuthService, private emailService: EmailService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.tokenInfo = this.auth.decodeToken()
    this.verified = this.tokenInfo['verified'];
  }

  verifyEmail(): void {
    this.emailService.sendVerifyEmail().subscribe(
      data => this.openDialog(data),
      error => console.log(error)
    )
  }

  openDialog(data): void {
    this.response = data;
    const verifyDialog = this.dialog.open(VerifyDialogComponent, {
      width: "350px",
      data: {code: 12345}
    });

    verifyDialog.afterClosed().subscribe( result => {
      if (result.event['status'] === 200) {
        this.verified = true
      }
    })

  }
}
