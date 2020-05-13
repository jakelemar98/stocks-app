import { Component, OnInit, Input } from '@angular/core';
import { stockInfo } from 'src/app/interfaces/stocks';
import { DeleteDialogComponent } from '../delete-dialog/delete-dialog.component';
import { MatDialog } from '@angular/material/dialog'
import { StocksService } from 'src/app/services/stocks/stocks.service';
@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.scss']
})
export class CardContainerComponent {
  @Input() stocks: stockInfo
  constructor(private dialog: MatDialog, private stockService: StocksService) { }

  deleteStock(symbol: string, index: number): void {
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      width: '250px',
      data: {symbol: this.stocks.data[index].symbol}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result == 1) {
        this.deleteStockData(symbol, index)
      }
    });
  }

  deleteStockData(symbol: string, index: number): void {
    this.stockService.deleteStockWatcher(symbol).subscribe(
      data => {
        console.log(data)
        this.stocks.data.splice(index, 1)
      },
      error => console.log(error),
    )

  }

}
