import { Component, OnInit } from '@angular/core';
import {FormControl, FormsModule} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import stocksJson from '../../../../assets/data/stocks.json'
import { StocksService } from '../../../services/stocks/stocks.service'
import { MatDialogRef } from '@angular/material/dialog';

export interface Stock {
  symbol: string;
  name: string;
}

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.scss']
})
export class AddStockComponent implements OnInit {

  stockCtrl = new FormControl();
  filteredStocks: Observable<Stock[]>;
  
  stocks: Stock[] = stocksJson

  constructor( private stocksService: StocksService, public dialogRef: MatDialogRef<AddStockComponent> ) {
    this.filteredStocks = this.stockCtrl.valueChanges
    .pipe(
      startWith(''),
      map(stock => stock ? this._filterStocks(stock) : this.stocks.slice())
    );
  }

  private _filterStocks(value: string): Stock[] {
    const filterValue = value.toLowerCase();

    return this.stocks.filter(stock => stock.name.toLowerCase().indexOf(filterValue) === 0);
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.stocksService.getStockPrice(this.stockCtrl.value).subscribe( data => {
      this.dialogRef.close({event: data});
    })
  }
}
