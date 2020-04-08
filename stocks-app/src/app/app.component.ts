import { Component } from '@angular/core';
import { StocksService } from './stocks.service';
import { UsersService } from './users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'stocks-app';
  matches: Object;
  price: Object;
  user: object;

  constructor(private stockHttp: StocksService, private userHttp: UsersService) { }

  ngOnInit() {
    // this.stockHttp.getStockMatches().subscribe(data => {
    //   this.matches = data
    //   var json = JSON.parse(this.matches["stockInfo"])
    //   console.log(json);
      
    // })

    // this.stockHttp.getStockPrice().subscribe(data => {
    //   this.price = data      
    //   var json = JSON.parse(this.price["stockInfo"])
    //   console.log(json);
    // })

    this.userHttp.getUser().subscribe(data => {
      this.user = data      
      console.log(this.user['message']);
    })
    
  }
}
