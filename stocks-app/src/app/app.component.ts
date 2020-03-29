import { Component } from '@angular/core';
import { StocksService } from './stocks.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'stocks-app';
  matches: Object;
  price: Object;
  obj: Object;
  obj2: Object;

  constructor(private http: StocksService) { }

  ngOnInit() {
    this.http.getStockMatches().subscribe(data => {
      this.matches = data
      this.obj2 = JSON.parse(this.matches.stockInfo);
      console.log(this.obj2[0].name);
    })

    this.http.getStockPrice().subscribe(data => {
      this.price = data
      this.obj = JSON.parse(this.price.stockInfo);
      console.log(this.obj["01. symbol"]);
    })  
  }
}
