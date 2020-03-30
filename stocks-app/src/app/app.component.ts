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

  constructor(private http: StocksService) { }

  ngOnInit() {
    this.http.getStockMatches().subscribe(data => {
      this.matches = data
      var json = JSON.parse(this.matches["stockInfo"])
      console.log(json);
      
    })

    this.http.getStockPrice().subscribe(data => {
      this.price = data      
      var json = JSON.parse(this.price["stockInfo"])
      console.log(json);
    })  
  }
}
