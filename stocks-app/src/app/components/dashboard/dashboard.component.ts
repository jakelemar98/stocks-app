import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmailService } from '../../services/email/email.service';
import { MatDialog } from '@angular/material/dialog';
import { VerifyDialogComponent } from './verify-dialog/verify-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { stockInfo } from  '../../interfaces/stocks';
import { AddStockComponent } from './add-stock/add-stock.component'
import { StocksService } from "../../services/stocks/stocks.service";
import { CalculationService } from "../../services/stocks/calculation.service";

interface WatchButton {
  text: string;
  icon: string;
  mode: string;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {

  tokenInfo: Object;
  response: Object;

  viewSwitch: string = "cards";
  userName: string;
  id: string;

  addStock: Boolean = true;
  verified: Boolean;

  stocks: stockInfo = {
    exists:  false,
    data: [],
    historical: [],
    length: 0
  };
  watcherButton: WatchButton = {
    text: 'Visualize',
    icon: "trending_up",
    mode: "chart"
  }

  constructor(
              public auth: AuthService, private emailService: EmailService,
              private stockService: StocksService, private dialog: MatDialog,
              private _snackBar: MatSnackBar, private calcService: CalculationService
            ) { }

  ngOnInit(): void {    
    this.tokenInfo = this.auth.decodeToken()
    this.verified = this.tokenInfo['verified'];
    this.userName = this.tokenInfo['first'] + " " + this.tokenInfo['last'];
    this.id = this.tokenInfo['user_id']
    this.fetchWatchingData()
  }

  verifyEmail(): void {
    this.emailService.sendVerifyEmail().subscribe(
      data => this.openDialog(data),
      error => console.log(error)
    )
  }

  fetchWatchingData(): void {
    this.stockService.getWatchingData().subscribe( 
        data => {
          var res = JSON.parse(data.response)
          var size = Object.keys(res).length;
          
          for (let i = 0; i < size; i++) {
            const element = res[i];
            var row = JSON.parse(element)
            var obj = {
              symbol: row[0],
              price: row[4],
              open: row[1],
              close: row[7]
            }
            this.stocks.data.push(obj)
            this.stocks.exists = true   
            this.stocks.length++         
          }
          this.fetchHistoricalData("loop", "")
        },
        error => console.log(error)
      )
  }

  fetchHistoricalData(method: string, sym: string): void {
    if (method === "loop") {
      for (let index = 0; index < this.stocks.data.length; index++) {
        const symbol = this.stocks.data[index].symbol.toLowerCase()
        
        this.stockService.getTimeSeries("monthly", symbol).subscribe(
          data => {
            const response: Object = data
            var res = JSON.parse(response['response'])
            
            this.stocks.historical.push(this.calcService.calcMonthlyChanges([3,6,12], res))                   
          },
          error => console.log(error)
          
        )
      }
    } else {
      this.stockService.getTimeSeries("monthly", sym).subscribe(
        data => {
          const response: Object = data
          var res = JSON.parse(response['response'])
          
          this.stocks.historical.push(this.calcService.calcMonthlyChanges([3,6,12], res))                   
        },
        error => console.log(error)
        
      )
    }
   
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
    if (this.stocks.data.length >= 4) {
      alert("sorry, no more then 4 stocks can be watched at a time")
    } else {
      const stockDialog = this.dialog.open(AddStockComponent, {
        width: "350px",
      });

      stockDialog.afterClosed().subscribe( result => {
        var data = JSON.parse(result.event.response)
        var obj = {
          symbol: data[0],
          price: data[4],
          open: data[1],
          close: data[7]
        }
        this.stocks.data.push(obj)
        this.stocks.exists = true
        this.stocks.length++
        this.fetchHistoricalData("single", obj.symbol)
        this.addStockWatcher(data[0])
      })
    }
  }

  verifiedSnackBar(message: string, action: string): void {
    this._snackBar.open(message, action, {
      duration: 3000,
    })
  }

  addStockWatcher(symbol: string): void {
    this.stockService.addStockWatcher(symbol).subscribe( data => {
      data => console.log(data);
    })
  }

  switchClick(mode: string): void {
    if (mode === "chart") {
      this.watcherButton = {
        text: 'Cards',
        icon: "info",
        mode: "cards"
      }
      this.viewSwitch = mode
    } else {
      this.watcherButton = {
        text: 'Visualize',
        icon: "trending_up",
        mode: "chart"
      }
      this.viewSwitch = mode
    }
  }
}
