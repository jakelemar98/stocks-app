import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmailService } from '../../services/email/email.service';
import { MatDialog } from '@angular/material/dialog';
import { VerifyDialogComponent } from './verify-dialog/verify-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { stockInfo } from  '../../interfaces/stocks';
import { AddStockComponent } from './add-stock/add-stock.component'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {

  tokenInfo: Object;
  response: Object;
  verified: Boolean;
  userName: string;
  paperTrader: Boolean = true;
  addStock: Boolean = true;
  stocks: stockInfo = {
    exists:  false,
    data: {
      symbol: "msft",
      price: 173.00,
      open: 171.00,
      close:  173.00
    }
  };

  constructor(public auth: AuthService, private emailService: EmailService, private dialog: MatDialog, private _snackBar: MatSnackBar) { }

  

  ngOnInit(): void {    
    this.tokenInfo = this.auth.decodeToken()
    this.verified = this.tokenInfo['verified'];
    this.userName = this.tokenInfo['first'] + " " + this.tokenInfo['last'];
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
        this.verified = true;
        this.verifiedSnackBar("Account Verified!", "close");
      }
    })
  }

  openAddDialog(): void {
    const stockDialog = this.dialog.open(AddStockComponent, {
      width: "350px",
    });
  }

  verifiedSnackBar(message: string, action: string): void {
    this._snackBar.open(message, action, {
      duration: 3000,
    })
  }
}
